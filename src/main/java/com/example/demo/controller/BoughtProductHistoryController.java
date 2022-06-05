package com.example.demo.controller;

import com.example.demo.entity.BoughtProductHistory;
import com.example.demo.service.BoughtProductHistoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/history")
public class BoughtProductHistoryController {
    @Autowired
    BoughtProductHistoryServiceInterface boughtProductHistoryServiceInterface;

    @GetMapping("/byInvoiceId/{id}")
    public List<BoughtProductHistory> getBoughtProductHistory(@PathVariable("id") Long id){
        return boughtProductHistoryServiceInterface.getHistoryByInvoiceId(id);
    }
}
