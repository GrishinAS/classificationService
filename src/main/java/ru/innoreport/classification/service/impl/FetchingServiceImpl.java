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
    private String uri = "http://10.91.45.196:8080/persistence/entities";


    @Override
    public List<Entity> fetch() {
        try {
            uri = System.getenv("ENTITY_PERSISTENCE_SERVICE_URL");
        }
        catch (Exception e){
            System.out.println("No ENTITY_PERSISTENCE_SERVICE_URL environment variable");
        }
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Entity>> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Entity>>(){});
        return response.getBody();
    }
}
