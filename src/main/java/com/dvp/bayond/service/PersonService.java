package com.dvp.bayond.service;

import com.dvp.bayond.domain.model.Person;
import com.dvp.bayond.domain.vo.IService;
import com.dvp.bayond.repository.IPersonRepository;
import com.dvp.bayond.service.exception.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements IService<Person> {


    @Autowired
    private IPersonRepository personRepository;

    @Override
    public List<Person> findAllModels() {
        return this.personRepository.findAll();
    }

    @Override
    public Person findByIdModel(Integer id) {
        Optional<Person> category = Optional.ofNullable(this.personRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado! id " +id )));
        return category.get();
    }

    @Override
    public Person saveModel(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public Person updateModel(Person person) {
        Person personDatabase = this.findByIdModel(person.getId());
        BeanUtils.copyProperties(person, personDatabase, "id");
        return this.personRepository.save(personDatabase);
    }

    @Override
    public void deletModelById(Integer id) {

    }
}
