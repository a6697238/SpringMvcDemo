package com.houlu.JavaTest.SpringMvcDemo.client;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Lu Hou
 * @date 2017/10/29
 * @time 上午12:27
 */
public class HttpClientUtil {

    //设置超时时间
    private static final int HTTP_SOCKET_TIMEOUT = 100000;
    private static final int HTTP_CONNECT_TIMEOUT = 100000;
    private static final int HTTP_CONNECTION_REQUEST_TIMEOUT = 100000;

    private static final String UPLOAD_FILE = "up_load_file";


    public static String doPostRequest(Map<String, String> paramsMap, String postUrl) throws IOException {
        HttpPost httpPost = new HttpPost(postUrl);
        String result;
        try (CloseableHttpClient httpClient = HttpClients.createDefault();) {
            List<NameValuePair> kvs = Lists.newArrayList();
            Iterator<Map.Entry<String, String>> it = paramsMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> entry = it.next();
                kvs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            httpPost.setEntity(new UrlEncodedFormEntity(kvs, StandardCharsets.UTF_8));
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(HTTP_SOCKET_TIMEOUT).setConnectionRequestTimeout(HTTP_CONNECTION_REQUEST_TIMEOUT).setConnectTimeout(HTTP_CONNECT_TIMEOUT).build();
            httpPost.setConfig(requestConfig);
            try (CloseableHttpResponse response = httpClient.execute(httpPost);) {
                result = EntityUtils.toString(response.getEntity());
            }
        }
        return result;
    }

    public static String doGetRequest(Map<String, String> paramsMap, String postUrl) throws IOException {
        HttpGet httpGet = new HttpGet(postUrl);
        String result;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(HTTP_SOCKET_TIMEOUT).setConnectionRequestTimeout(HTTP_CONNECTION_REQUEST_TIMEOUT).setConnectTimeout(HTTP_CONNECT_TIMEOUT).build();
            httpGet.setConfig(requestConfig);
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                result = EntityUtils.toString(response.getEntity());
            }
        }
        return result;
    }


    public static String doPostForUpLoad(byte[] bytes, Map<String, String> paramsMap, String postUrl) throws ParseException, IOException {
        HttpPost httpPost = new HttpPost(postUrl);
        String result;
        try (CloseableHttpClient httpClient = HttpClients.createDefault();) {
            MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
            entityBuilder.addBinaryBody("file", bytes, ContentType.DEFAULT_BINARY, UPLOAD_FILE);
            Iterator<Map.Entry<String, String>> it = paramsMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> entry = it.next();
                entityBuilder.addTextBody(entry.getKey(), entry.getValue());
            }
            httpPost.setEntity(entityBuilder.build());
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(HTTP_SOCKET_TIMEOUT).setConnectionRequestTimeout(HTTP_CONNECTION_REQUEST_TIMEOUT).setConnectTimeout(HTTP_CONNECT_TIMEOUT).build();
            httpPost.setConfig(requestConfig);
            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                result = EntityUtils.toString(response.getEntity());
            }
        }
        return result;
    }


    public static void main(String[] args) throws IOException, ParseException {
//        String url = "http://localhost:8082/SpringMvcDemo/user/userLogin";
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("username", "username");
        paramMap.put("password", "password");
//        postForm(paramMap,url);

        FileInputStream fileInputStream = new FileInputStream("/Users/luhou/Downloads/7bcfd752da0bf63b36399618fe3f8fb4.pdf");
        byte[] bytes = new byte[1024 * 1024];
        fileInputStream.read(bytes);
        doPostForUpLoad(bytes, paramMap, "http://localhost:8082/SpringMvcDemo/user/userUpload");

    }
}
