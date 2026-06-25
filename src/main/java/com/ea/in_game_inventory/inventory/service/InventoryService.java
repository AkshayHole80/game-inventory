package com.ea.in_game_inventory.inventory.service;

import com.ea.in_game_inventory.inventory.dto.request.InventoryRequest;
import com.ea.in_game_inventory.inventory.dto.response.InventoryResponse;

public interface InventoryService {
    InventoryResponse createItem(InventoryRequest request);
}
