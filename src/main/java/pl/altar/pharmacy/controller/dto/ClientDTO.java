package pl.altar.pharmacy.controller.dto;

import pl.altar.pharmacy.domain.Client;

import java.time.LocalDate;

public class ClientDTO {

    private Long id;

    private String name;

    private String surname;

    private Integer yearOfBirth;

    private Integer age;

    public ClientDTO() {
    }

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.surname = client.getSurname();
        this.yearOfBirth = client.getYearOfBirth();
        this.age = LocalDate.now().getYear() - client.getYearOfBirth();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Integer getAge() {
        return age;
    }
}
