package com.example.demo.repository;

import com.example.demo.entity.InvoiceHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceHistoryRepository extends JpaRepository<InvoiceHistoryEntity, Long> {
}
