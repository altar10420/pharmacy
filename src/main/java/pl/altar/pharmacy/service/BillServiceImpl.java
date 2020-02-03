package pl.altar.pharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.altar.pharmacy.domain.Bill;
import pl.altar.pharmacy.domain.Client;
import pl.altar.pharmacy.repository.BillRepository;
import pl.altar.pharmacy.repository.ClientRepository;

import java.time.LocalDateTime;

@Service
@Transactional(readOnly = true)
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public BillServiceImpl(BillRepository billRepository, ClientRepository clientRepository) {
        this.billRepository = billRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    @Transactional
    public Long createBill(Long clientId) {

        Client client = clientRepository.getById(clientId);

        Bill bill = new Bill(client);

        billRepository.save(bill);

        return bill.getId();
    }

    @Override
    public Bill getBill(Long billId) {

        return billRepository.getById(billId);
    }
}
