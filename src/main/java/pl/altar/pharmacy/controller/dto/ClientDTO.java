package pl.altar.pharmacy.controller.dto;

import pl.altar.pharmacy.domain.Client;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class ClientDTO {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private Integer yearOfBirth;

    public ClientDTO(Long id, String name, String surname, Integer yearOfBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
    }

    public ClientDTO(Client client) {
        this.id = client.getId();
    }
}
