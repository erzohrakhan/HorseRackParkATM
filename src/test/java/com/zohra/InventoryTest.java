package com.zohra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InventoryTest {
    private Inventory inventory;
    @BeforeEach
    void setUp() {
        inventory = new Inventory();
    }

    @Test
    void dispense_InsufficientFunds_ExceptionThrown() {
        assertThrows(HorseTrackException.class, () -> inventory.dispense(1000));
    }


}