package com.service.salesforce;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.service.salesforce.request.BaseSalesforceRequest;
import com.service.salesforce.request.SalesforceRequest;
import com.service.salesforce.response.SalesforceResponse;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class RestfulSalesforceClient implements SalesforceClient {

    private String instanceUrl;
    private String apiVersion;
    protected String urlPath;

    public String getInstanceUrl() {
        return instanceUrl;
    }

    public void setInstanceUrl(String instanceUrl) {
        this.instanceUrl = instanceUrl;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String urlPath() {
        return instanceUrl + "/services/data/" + apiVersion + "/sobjects";
    }

    public void execute(BaseSalesforceRequest request) throws Exception {
        final JsonNode loginResult = getAccessToken();
        final String accessToken = loginResult.get("access_token").asText();
        instanceUrl = loginResult.get("instance_url").asText();
        //
        System.out.println("sf accesstoken: " + accessToken);
        final HttpPatch httpPatch = new HttpPatch(urlPath() + request.getResourceUrl());
        //
        System.out.println("url: " + urlPath() + request.getResourceUrl());
        httpPatch.setHeader("Authorization", "Bearer " + accessToken);
        StringEntity entity = new StringEntity(request.toString());
        httpPatch.setEntity(entity);
        httpPatch.setHeader("Accept", "application/json");
        httpPatch.setHeader("Content-type", "application/json");
        final CloseableHttpClient httpclient = HttpClients.createDefault();
        httpclient.execute(httpPatch);

    }

    private JsonNode getAccessToken() throws IOException {
        String accessToken = "";
        // login
        final CloseableHttpClient httpclient = HttpClients.createDefault();

        final List<NameValuePair> loginParams = new ArrayList<NameValuePair>();
        loginParams.add(new BasicNameValuePair("client_id", "3MVG9n_HvETGhr3Dj99T0Et70GStY2mOrqjuvg0ZY9ya.xaW3Morpkp9mbOooGHIMq7j4GFPdh2hwf6HI5BPQ"));
        loginParams.add(new BasicNameValuePair("client_secret", "5F530361626846192F1624010E10BFD3EB8DF4BFC8BD635982368AF4984B3786"));
        loginParams.add(new BasicNameValuePair("grant_type", "password"));
        loginParams.add(new BasicNameValuePair("username", "jaiminwu@rocksalesforce.com"));
        loginParams.add(new BasicNameValuePair("password", "JaiminRockSalesforce!2020SzAwGladMArazTsaMStdyRfG7"));

        final HttpPost post = new HttpPost("https://login.salesforce.com/services/oauth2/token");
        post.setEntity(new UrlEncodedFormEntity(loginParams));

        final HttpResponse loginResponse = httpclient.execute(post);

        // parse
        final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        final JsonNode loginResult = mapper.readValue(loginResponse.getEntity().getContent(), JsonNode.class);

        return loginResult;
    }

}
