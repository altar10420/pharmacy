package pl.altar.pharmacy.service;

import pl.altar.pharmacy.domain.Bill;

import java.util.List;

public interface BillService {

    Long createBill(Long clientId);

    Bill getBill(Long billId);

    List<Bill> getAllBills();

    Long addProduct(Long billId, Long productId);

}
