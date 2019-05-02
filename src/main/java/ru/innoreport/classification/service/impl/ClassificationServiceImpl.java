package ru.innoreport.classification.service.impl;

import org.springframework.stereotype.Service;
import ru.innoreport.classification.models.Entity;
import ru.innoreport.classification.service.ClassificationService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    @Override
    public List<Entity> map(List<Entity> entities, String[] tags) {

        List<Entity> result = new ArrayList<>();
        for(String reportTag :tags){
            for(Entity entity :entities){
                String[] entityTags = entity.getTags();
                for(String entityTag :entityTags){
                    if(entityTag.toUpperCase().equals(reportTag)){
                        result.add(entity);
                    }
                }
            }
        }
        return result.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
