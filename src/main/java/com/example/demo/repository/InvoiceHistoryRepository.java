package com.example.demo.repository;

import com.example.demo.entity.InvoiceHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InvoiceHistoryRepository extends JpaRepository<InvoiceHistoryEntity, Long> {

    @Query(value = "select * from invoice_history i where i.invoice_id=?1", nativeQuery = true)
    InvoiceHistoryEntity invoiceById(Long invoice_id);
}
