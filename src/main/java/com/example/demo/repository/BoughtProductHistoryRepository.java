package com.example.demo.repository;

import com.example.demo.entity.BoughtProductHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoughtProductHistoryRepository extends JpaRepository<BoughtProductHistory, Long> {
}
