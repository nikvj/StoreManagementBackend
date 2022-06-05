package com.example.demo.service;

import com.example.demo.entity.BoughtProductHistory;
import com.example.demo.repository.BoughtProductHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoughtProductHistoryService implements BoughtProductHistoryServiceInterface{
    @Autowired
    BoughtProductHistoryRepository boughtProductHistoryRepository;
    @Override
    public void addBoughtHistory(BoughtProductHistory boughtProductHistory) {
        boughtProductHistoryRepository.save(boughtProductHistory);
    }

    @Override
    public List<BoughtProductHistory> getHistoryByInvoiceId(Long invoice_id) {
        List<BoughtProductHistory> list = boughtProductHistoryRepository.boughtProductHistoryByInvoiceId(invoice_id);
        return list;
    }
}
