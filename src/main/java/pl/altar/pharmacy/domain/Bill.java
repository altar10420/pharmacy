package pl.altar.pharmacy.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column
    private BigDecimal price;

    @ManyToOne()
    @JoinColumn(name = "client_id")
    private Client client;

    public Bill() {
    }

    public Bill(Client client) {
        this.dateTime = LocalDateTime.now();
        this.price = BigDecimal.valueOf(0);
        this.client = client;
    }

    public Bill(Long id, LocalDateTime dateTime, BigDecimal price, Client client) {
        this.id = id;
        this.dateTime = dateTime;
        this.price = price;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Objects.equals(id, bill.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Bill.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("dateTime=" + dateTime)
                .add("price=" + price)
                .add("client=" + client)
                .toString();
    }
}
