package com.ea.in_game_inventory.inventory.dto.request;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class QuantityUpdateRequest {

    @Min(value = 1, message = "Quantity must be greater than 0")
    private Integer quantity;
}