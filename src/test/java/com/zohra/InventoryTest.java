package com.zohra;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InventoryTest {
  private Inventory inventory;

  @BeforeEach
  void setUp() {
    inventory = new Inventory();
  }

  @Test
  void dispense_InsufficientFunds_ExceptionThrown() {
    assertThrows(HorseTrackException.class, () -> inventory.dispense(10000));
  }

  @Test
  void restock_RestockInventory_Success() {
    List<Denomination> denominations =
        Arrays.asList(
            new Denomination(1, 10),
            new Denomination(5, 10),
            new Denomination(10, 10),
            new Denomination(20, 10),
            new Denomination(100, 10));
    inventory.restock();
    assertEquals(denominations, inventory.getDenominationList());
  }
}
