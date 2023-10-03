package com.example.bookmanagementsystem.controller;

import com.example.bookmanagementsystem.modules.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class testController {
    @GetMapping("/test")
    public void test(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("1", 1, "order"));
        items.add(new Item("2", 2, "pack"));
        items.add(new Item("3", 3, "pack"));
        List<Item> filterItems = items.stream().filter( item -> item.getQty() == 3 || item.getQty()==1).collect(Collectors.toList());
        System.out.println(filterItems.toString());

        List<String> strings = Arrays.asList("Hello", "World", "Bye");

        List<Item> objects = strings.stream()
                .map(Item::new)
                .collect(Collectors.toList());
        System.out.println(objects.toString());

    }

    @GetMapping("/filter")
    public void filter(){
        
    }
}
