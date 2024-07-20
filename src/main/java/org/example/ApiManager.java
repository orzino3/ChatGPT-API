package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;




public class ApiManager
{

    public static final String SEND_MESSEGE = "https://app.seker.live/fm1/send-message";
    public static final String CLEAR_HISTORY = "https://app.seker.live/fm1/clear-history";
    public static final String CHECK_BALANCE = "https://app.seker.live/fm1/check-balance";


    private CloseableHttpClient client;


    public ApiManager(){
        client = HttpClients.createDefault();
    }

    public void setSendMessege(String messege){
        try {
            URI uri = new URIBuilder(SEND_MESSEGE)
                    .setParameter("id", "311433957")
                    .setParameter("text", messege)
                    .build();
            HttpGet get = new HttpGet(uri);
            CloseableHttpResponse response = client.execute(get);
            String response1 = EntityUtils.toString(response.getEntity());
            Response chatResponse = new ObjectMapper().readValue(response1,Response.class);
            System.out.println(chatResponse.getExtra());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

