package com.zohra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlaceBetCommandTest {
    private PlaceBetCommand placeBetCommand;
    private Inventory inventory;
    private HorseRace horseRace;

    @BeforeEach
    void setUp() {
        inventory = mock(Inventory.class);
        horseRace = mock(HorseRace.class);
        placeBetCommand = new PlaceBetCommand(1, 100, inventory, horseRace);
    }

    @Test
    void execute_ValidHorse_WinningsDispensed() {
        when(horseRace.checkInValidHorseNumber(anyInt())).thenReturn(false);
        Horse horse = mock(Horse.class);
        when(horse.hasWon()).thenReturn(true);
        when(horse.getOdds()).thenReturn(2);
        when(horseRace.getHorseByNumber(anyInt())).thenReturn(horse);

        placeBetCommand.execute();

        verify(inventory, times(1)).dispense(anyInt());
    }

    @Test
    void execute_InvalidHorse_ExceptionThrown() {
        when(horseRace.checkInValidHorseNumber(anyInt())).thenReturn(true);

        assertThrows(HorseTrackException.class, () -> placeBetCommand.execute());
    }

    @Test
    void execute_NoPayout_ExceptionThrown() {
        Horse horse = mock(Horse.class);
        when(horse.hasWon()).thenReturn(false);
        assertThrows(HorseTrackException.class, () -> placeBetCommand.execute());

    }

}
