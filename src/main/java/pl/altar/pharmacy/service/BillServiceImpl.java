package pl.altar.pharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.altar.pharmacy.domain.Bill;
import pl.altar.pharmacy.domain.Client;
import pl.altar.pharmacy.domain.Product;
import pl.altar.pharmacy.repository.BillRepository;
import pl.altar.pharmacy.repository.ClientRepository;
import pl.altar.pharmacy.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;

    @Autowired
    public BillServiceImpl(BillRepository billRepository,
                           ClientRepository clientRepository,
                           ProductRepository productRepository) {
        this.billRepository = billRepository;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
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

    @Override
    public List<Bill> getAllBills() {

        List<Bill> billList = new ArrayList<>();

        for (Bill bill : billRepository.findAll()) {
            billList.add(bill);
        }
        return billList;
    }

    @Override
    @Transactional
    public Long addProduct(Long billId, Long productId) {

        Bill bill = billRepository.getById(billId);

        Product product = productRepository.getById(productId);

        bill.getProducts().add(product);

        billRepository.save(bill);

        return bill.getId();
    }
}
