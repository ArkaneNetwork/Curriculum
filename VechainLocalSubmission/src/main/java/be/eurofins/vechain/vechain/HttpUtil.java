package be.eurofins.vechain.vechain;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <T, R> R postJson(String url, T jsonBody, Class<R> returnType) {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            StringEntity requestEntity = new StringEntity(
                    objectMapper.writeValueAsString(jsonBody),
                    ContentType.APPLICATION_JSON);

            HttpPost postMethod = new HttpPost(url);
            postMethod.setEntity(requestEntity);
            HttpResponse rawResponse = httpClient.execute(postMethod);
            String response = EntityUtils.toString(rawResponse.getEntity(), "UTF-8");
            return objectMapper.readValue(response, returnType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <R> R getJson(String url, Class<R> returnType) {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpGet httpGet = new HttpGet(url);
            HttpResponse rawResponse = httpClient.execute(httpGet);
            String response = EntityUtils.toString(rawResponse.getEntity(), "UTF-8");
            return response == null ? null : objectMapper.readValue(response, returnType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
