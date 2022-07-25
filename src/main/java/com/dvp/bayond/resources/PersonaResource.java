package com.dvp.bayond.resources;

import com.dvp.bayond.domain.model.Person;
import com.dvp.bayond.domain.model.Product;
import com.dvp.bayond.domain.vo.IResource;
import com.dvp.bayond.service.PersonService;
import com.dvp.bayond.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonaResource implements IResource<Person> {

    @Autowired
    private PersonService personService;

    @GetMapping
    @Override
    public ResponseEntity<List<Person>> getAllModels() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.personService.findAllModels());
    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<Person> getByIdModel(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.personService.findByIdModel(id));
    }

    @PostMapping
    @Override
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.personService.saveModel(person));
    }

    @PutMapping
    @Override
    public ResponseEntity<Person> update(@RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(this.personService.updateModel(person));
    }

    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<Person> deletById(@PathVariable Integer id) {
        this.personService.deletModelById(id);
        return ResponseEntity.ok().build();
    }
}
