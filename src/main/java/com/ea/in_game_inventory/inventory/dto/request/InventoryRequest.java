package com.ea.in_game_inventory.inventory.dto.request;

 import com.ea.in_game_inventory.inventory.enums.Rarity;
 import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
 import org.hibernate.validator.constraints.UniqueElements;

@Data
public class InventoryRequest {

    @NotBlank(message = "Player Id is required")
    private String playerId;

    @NotBlank(message = "Item Name cannot be empty")
    private String itemName;

    @Min(value = 1, message = "Quantity must be greater than 0")
    private Integer quantity;

    @NotNull(message = "Rarity is required")
    private Rarity rarity;
}