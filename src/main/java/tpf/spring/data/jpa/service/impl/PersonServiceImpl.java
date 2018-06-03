package tpf.spring.data.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpf.spring.data.jpa.entity.Person;
import tpf.spring.data.jpa.repository.PersonRepository;
import tpf.spring.data.jpa.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Long savePerson() {
        Person person = new Person();
        person.setUsername("XRog");
        person.setPhone("18381005946");
        person.setAddress("chenDu");
        person.setRemark("this is XRog");
        return personRepository.save(person);
    }
}
