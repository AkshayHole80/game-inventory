package com.ea.in_game_inventory.inventory.service;

import com.ea.in_game_inventory.inventory.dto.request.InventoryRequest;
import com.ea.in_game_inventory.inventory.dto.request.QuantityUpdateRequest;
import com.ea.in_game_inventory.inventory.dto.response.InventoryResponse;

import java.util.List;

public interface InventoryService {
    InventoryResponse createItem(InventoryRequest request);
    List<InventoryResponse> getItemsByPlayerId(String playerId);
    List<InventoryResponse> getRareItemsByPlayerId(String playerId);
    InventoryResponse updateQuantity(
            String id,
            QuantityUpdateRequest request
    );
    void deleteItem(String id);
}
