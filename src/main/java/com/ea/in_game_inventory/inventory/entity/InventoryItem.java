package com.ea.in_game_inventory.inventory.entity;

 import com.ea.in_game_inventory.inventory.enums.Rarity;
 import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "inventory_items")
public class InventoryItem {

    @Id
    private String id;

    private String playerId;

    private String itemName;

    private Integer quantity;

    private Rarity rarity;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}