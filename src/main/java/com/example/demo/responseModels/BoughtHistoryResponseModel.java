package com.example.demo.responseModels;

import com.example.demo.models.BoughtProductHistory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoughtHistoryResponseModel {
    List<BoughtProductHistory> boughtProductHistoryList;
}
