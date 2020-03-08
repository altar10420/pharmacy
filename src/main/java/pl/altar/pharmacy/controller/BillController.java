package pl.altar.pharmacy.controller;

import org.springframework.web.bind.annotation.*;
import pl.altar.pharmacy.controller.dto.BillDTO;
import pl.altar.pharmacy.domain.Bill;
import pl.altar.pharmacy.service.BillService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(BillController.BASE_URL)
public class BillController {

    public static final String BASE_URL = "/api/bills";

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping(path = "/getAll")
    public List<BillDTO> billDTOList() {

        List<BillDTO> billDTOList = new ArrayList<>();

        for(Bill bill : billService.getAllBills()) {
            billDTOList.add(new BillDTO(bill));
        }

        return billDTOList;
    }

    @PostMapping(path = "/create")
    public Long createBill(@RequestParam(name = "client") Long clientId) {

        Long billId = billService.createBill(clientId);

        return billId;
    }

    @PutMapping(path = "/{id}/addProduct")
    public Long addProduct(@PathVariable("id") Long id, @RequestParam(name = "product") Long productId) {

        Long billId = billService.addProduct(id, productId);

        return billId;
    }

}
