package com.ea.in_game_inventory.inventory.service.impl;

import com.ea.in_game_inventory.inventory.dto.request.InventoryRequest;
import com.ea.in_game_inventory.inventory.dto.request.QuantityUpdateRequest;
import com.ea.in_game_inventory.inventory.dto.response.InventoryResponse;
import com.ea.in_game_inventory.inventory.entity.InventoryItem;
import com.ea.in_game_inventory.inventory.enums.Rarity;
import com.ea.in_game_inventory.inventory.exception.ItemNotFoundException;
import com.ea.in_game_inventory.inventory.repository.InventoryRepository;
import com.ea.in_game_inventory.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;
    private final ModelMapper modelMapper;
    @Override
    public InventoryResponse createItem(InventoryRequest request) {

        log.info("Creating inventory item for player: {}", request.getPlayerId());

        InventoryItem inventoryItem =
                modelMapper.map(request, InventoryItem.class);

        InventoryItem savedItem =
                inventoryRepository.save(inventoryItem);

        log.info("Inventory item created successfully with id: {}", savedItem.getId());

        return modelMapper.map(savedItem, InventoryResponse.class);
    }

    @Override
    public List<InventoryResponse> getItemsByPlayerId(String playerId) {

        log.info("Fetching inventory items for player: {}", playerId);

        List<InventoryItem> inventoryItems =
                inventoryRepository.findByPlayerId(playerId);

        log.info("Found {} inventory items for player {}",
                inventoryItems.size(),
                playerId);

        return inventoryItems.stream()
                .map(item -> modelMapper.map(item, InventoryResponse.class))
                .toList();
    }
    @Override
    public List<InventoryResponse> getRareItemsByPlayerId(String playerId) {

        log.info("Fetching rare inventory items for player: {}", playerId);

        List<InventoryItem> inventoryItems =
                inventoryRepository.findByPlayerIdAndRarityIn(
                        playerId,
                        List.of(Rarity.RARE, Rarity.EPIC)
                );

        log.info("Found {} rare items for player {}",
                inventoryItems.size(),
                playerId);

        return inventoryItems.stream()
                .map(item -> modelMapper.map(item, InventoryResponse.class))
                .toList();
    }

    @Override
    public InventoryResponse updateQuantity(
            String id,
            QuantityUpdateRequest request) {

        log.info("Updating quantity for inventory item: {}", id);

        InventoryItem inventoryItem = inventoryRepository.findById(id)
                .orElseThrow(() -> {

                    log.warn("Inventory item not found with id: {}", id);

                    return new ItemNotFoundException(
                            "Inventory item not found with id: " + id
                    );
                });

        inventoryItem.setQuantity(request.getQuantity());

        InventoryItem updatedItem =
                inventoryRepository.save(inventoryItem);

        log.info("Inventory quantity updated successfully.");

        return modelMapper.map(updatedItem, InventoryResponse.class);
    }
 }
