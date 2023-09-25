package kz.auk.solvaproj.service;

import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateService {
    public <T> T send(String uri, Object entity, Class<T> classType) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (entity == null) {
            ResponseEntity<T> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), classType);
            if (responseEntity.getBody() == null) {
                return null;
            } else {
                return responseEntity.getBody();
            }
        } else {
            return restTemplate.postForObject(uri, new HttpEntity<>(new JSONObject(entity).toString(), headers), classType);
        }
    }
}
