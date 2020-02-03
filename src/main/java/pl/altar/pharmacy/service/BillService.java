package pl.altar.pharmacy.service;

import pl.altar.pharmacy.domain.Bill;

import java.time.LocalDateTime;

public interface BillService {

    Long createBill(Long clientId);

    Bill getBill(Long billId);

}
