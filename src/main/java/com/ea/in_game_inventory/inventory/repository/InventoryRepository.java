package com.ea.in_game_inventory.inventory.repository;

import com.ea.in_game_inventory.inventory.entity.InventoryItem;
import com.ea.in_game_inventory.inventory.enums.Rarity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InventoryRepository extends MongoRepository<InventoryItem, String> {

    List<InventoryItem> findByPlayerId(String playerId);

    List<InventoryItem> findByPlayerIdAndRarityIn(
            String playerId,
            List<Rarity> rarities
    );

}