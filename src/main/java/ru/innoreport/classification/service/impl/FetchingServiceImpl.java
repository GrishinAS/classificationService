package ru.innoreport.classification.service.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.innoreport.classification.models.Entity;
import ru.innoreport.classification.service.EntitiesFetchingService;

import java.util.List;

@Service
public class FetchingServiceImpl implements EntitiesFetchingService {
    final private String uri = "http://10.90.138.222:8082/persistence/entities"; //Remote IP


    @Override
    public List<Entity> fetch() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Entity>> response = restTemplate.exchange(
                getUrlSystemEnv(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Entity>>(){});
        return response.getBody();
    }

    private String getUrlSystemEnv(){
        String envUri = System.getenv("ENTITY_PERSISTENCE_SERVICE_URL");
        if(envUri==null){
            return uri;
        }
        else {
            return envUri;
        }
    }
}
