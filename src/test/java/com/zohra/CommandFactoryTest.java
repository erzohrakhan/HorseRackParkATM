package com.zohra;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandFactoryTest {
  private Inventory mockInventory;
  private HorseRace mockHorseRace;

  @BeforeEach
  void setup() {
    mockInventory = mock(Inventory.class);
    mockHorseRace = mock(HorseRace.class);
  }

  @Test
  void testCreateCommand_RestockCommand_Success() {
    Command command = CommandFactory.createCommand("r", mockInventory, mockHorseRace);
    assertTrue(command instanceof RestockCommand);
  }

  @Test
  void testCreateCommand_QuitCommand_Success() {
    Command command = CommandFactory.createCommand("q", mockInventory, mockHorseRace);
    assertTrue(command instanceof QuitCommand);
  }

  @Test
  void testCreateCommand_SetWinningHorseCommand_Success() {
    Command command = CommandFactory.createCommand("w 3", mockInventory, mockHorseRace);
    assertTrue(command instanceof SetWinningHorseCommand);
  }

  @Test
  void testCreateCommand_PlaceBetCommand_Success() {
    Command command = CommandFactory.createCommand("1 50", mockInventory, mockHorseRace);
    assertTrue(command instanceof PlaceBetCommand);
  }

  @Test
  void testCreateCommand_InvalidInput_ReturnsNull() {
    Command command = CommandFactory.createCommand("invalid", mockInventory, mockHorseRace);
    assertNull(command);
  }

  @Test
  void testCreateCommand_InvalidBetAmount_ThrowsException() {
    assertThrows(
        HorseTrackException.class,
        () -> CommandFactory.createCommand("1 0.5", mockInventory, mockHorseRace));
  }
}
