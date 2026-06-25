package com.ea.in_game_inventory.inventory.controller;

import com.ea.in_game_inventory.inventory.dto.request.InventoryRequest;
import com.ea.in_game_inventory.inventory.dto.request.QuantityUpdateRequest;
import com.ea.in_game_inventory.inventory.dto.response.InventoryResponse;
import com.ea.in_game_inventory.inventory.service.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{playerId}")
    public ResponseEntity<List<InventoryResponse>> getItemsByPlayerId(
            @PathVariable String playerId) {

        return ResponseEntity.ok(
                inventoryService.getItemsByPlayerId(playerId)
        );
    }
    @GetMapping("/{playerId}/rare")
    public ResponseEntity<List<InventoryResponse>> getRareItems(
            @PathVariable String playerId) {

        List<InventoryResponse> response =
                inventoryService.getRareItemsByPlayerId(playerId);

        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}/quantity")
    public ResponseEntity<InventoryResponse> updateQuantity(
            @PathVariable String id,
            @Valid @RequestBody QuantityUpdateRequest request) {

        InventoryResponse response =
                inventoryService.updateQuantity(id, request);

        return ResponseEntity.ok(response);
    }

}
