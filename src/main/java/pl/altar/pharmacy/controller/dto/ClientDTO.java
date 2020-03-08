package pl.altar.pharmacy.controller.dto;

import lombok.*;
import pl.altar.pharmacy.domain.Client;

import java.time.LocalDate;

@Data
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
}
