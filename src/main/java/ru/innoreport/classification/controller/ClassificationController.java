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
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/classification")
public class ClassificationController {

    private List<Entity> entities;

    @Autowired
    ClassificationService classificationService;

    @Autowired
    EntitiesFetchingService entitiesFetchingService;

    @RequestMapping(value = "/classify/{tags}", method = RequestMethod.GET)
    public List<Entity> getMappedEntities(@PathVariable String[] tags){
        if(entities!=null) return classificationService.map(entities,tags);
            else return null;
    }

    @PostConstruct
    public void callDB() {
        try {
            entities = entitiesFetchingService.fetch();
        }
        catch (Exception e){
            System.out.println("Data fetching error");

            entities = new ArrayList<>();
            entities.add(new Entity("Hospital","sobaka@sobaka.pes","Pushkina 1", new String[]{"MEDICINE","HEALTH"}));
            entities.add(new Entity("Electrition Station","power@rangers.com","Petushki 1", new String[]{"ELECTRICITY"}));
        }

    }

}
