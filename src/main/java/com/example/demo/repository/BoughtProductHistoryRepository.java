package com.example.demo.repository;

import com.example.demo.entity.BoughtProductHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoughtProductHistoryRepository extends JpaRepository<BoughtProductHistory, Long> {

    @Query(value = "select * from bought_product_history b where b.invoice_id=?1", nativeQuery = true)
    List<BoughtProductHistory> boughtProductHistoryByInvoiceId(Long invoice_id);
}
