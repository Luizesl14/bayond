package com.dvp.bayond.domain.model;

import com.dvp.bayond.domain.enums.ClinetType;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "person")
public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;
    private String email;
    private String taxId;
    private Integer type;

    @OneToMany(mappedBy = "person")
    private List<Address> addresses = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "phones")
    private Set<String> phones =  new HashSet<>();


    public Person(Integer id, String name,
                  String email, String taxId, ClinetType type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.taxId = taxId;
        this.type = type.getCod();
    }

    public Person() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public ClinetType getType() {
        return ClinetType.toEnum(this.type);
    }

    public void setType(ClinetType type) {
        this.type = type.getCod();
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
