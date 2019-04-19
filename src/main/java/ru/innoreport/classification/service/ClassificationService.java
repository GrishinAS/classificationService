package ru.innoreport.classification.service;

import org.springframework.stereotype.Service;
import ru.innoreport.classification.models.Entity;

import java.util.List;

@Service
public interface ClassificationService {
    List<Entity> map(List<Entity> entities, String[] tags);
}
