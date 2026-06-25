package com.ea.in_game_inventory.inventory.controller;

import com.ea.in_game_inventory.inventory.dto.request.InventoryRequest;
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


}
