package com.ea.in_game_inventory.inventory.controller;

import com.ea.in_game_inventory.inventory.dto.request.InventoryRequest;
import com.ea.in_game_inventory.inventory.dto.response.InventoryResponse;
import com.ea.in_game_inventory.inventory.service.InventoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<InventoryResponse> createItem(
            @Valid @RequestBody InventoryRequest request) {

        InventoryResponse response = inventoryService.createItem(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
