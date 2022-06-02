package com.example.demo.service;

import com.example.demo.entity.BoughtProductHistory;
import com.example.demo.repository.BoughtProductHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoughtProductHistoryService implements BoughtProductHistoryServiceInterface{
    @Autowired
    BoughtProductHistoryRepository boughtProductHistoryRepository;
    @Override
    public void addBoughtHistory(BoughtProductHistory boughtProductHistory) {
        boughtProductHistoryRepository.save(boughtProductHistory);
    }
}
