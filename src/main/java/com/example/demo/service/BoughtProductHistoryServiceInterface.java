package com.example.demo.service;

import com.example.demo.entity.BoughtProductHistory;

import java.util.List;

public interface BoughtProductHistoryServiceInterface {
    void addBoughtHistory(BoughtProductHistory boughtProductHistory);

    List<BoughtProductHistory> getHistoryByInvoiceId(Long invoice_id);
}
