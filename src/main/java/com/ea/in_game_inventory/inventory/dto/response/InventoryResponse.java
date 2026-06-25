package com.ea.in_game_inventory.inventory.dto.response;

import com.ea.in_game_inventory.inventory.enums.Rarity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InventoryResponse {

    private String id;

    private String playerId;

    private String itemName;

    private Integer quantity;

    private Rarity rarity;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}