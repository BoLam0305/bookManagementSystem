package com.example.bookmanagementsystem.modules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    private String skuCode;

    private Integer qty;

    private String type;

    public Item(String s) {
        this.skuCode = s;
    }

    public Integer changeQty(Integer qty){
        return qty *= 10;
    }
}
