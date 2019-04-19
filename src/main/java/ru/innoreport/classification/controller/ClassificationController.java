package ru.innoreport.classification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.innoreport.classification.models.Entity;
import ru.innoreport.classification.service.ClassificationService;
import ru.innoreport.classification.service.EntitiesFetchingService;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/classification")
public class ClassificationController {

    private List<Entity> entities;

    @Autowired
    ClassificationService classificationService;

    @Autowired
    EntitiesFetchingService entitiesFetchingService;

    @RequestMapping(value = "/classify/{report_id}/{tags}", method = RequestMethod.GET)
    public List<Entity> getReportsHistory(@PathVariable String report_id,
                                          @PathVariable String[] tags){

        if(entities!=null) return classificationService.map(entities,tags);
            else return null;
    }

    @PostConstruct
    public void callDB() {
        entities = entitiesFetchingService.fetch();
    }

}
