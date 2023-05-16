package com.prior.restaurant.controller.rest;


import com.prior.restaurant.exception.BaseException;
import com.prior.restaurant.models.BillModel;
import com.prior.restaurant.models.ResponseModel;
import com.prior.restaurant.models.IncomeModel;
import com.prior.restaurant.service.BillService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/cashier/api")
public class CashierController {

    private final BillService billService;

    public CashierController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/bills")
    public ResponseModel<List<BillModel>> getBills() throws BaseException {
        return  billService.getBills();
    }

    @GetMapping("/getPdf/{uuid}")
    public void getPdf(@PathVariable(required = true ,name = "uuid")String uuid  , HttpServletResponse httpServletResponse) throws BaseException, IOException {
         billService.getPdf(uuid , httpServletResponse);
    }

    @PostMapping("/getIncome")
    public ResponseModel<IncomeModel> getIncome(@RequestBody IncomeModel incomeModel) throws BaseException {
        return billService.getIncome(incomeModel);
    }

}
