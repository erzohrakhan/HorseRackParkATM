package com.zohra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SetWinningHorseCommandTest {
    private SetWinningHorseCommand setWinningHorseCommand;
    private HorseRace horseRace;

    @BeforeEach
    void setUp() {
        horseRace = mock(HorseRace.class);
        setWinningHorseCommand = new SetWinningHorseCommand(1, horseRace);
    }

    @Test
    void execute_ValidHorseNumber_WinningHorseSet() {
        when(horseRace.checkInValidHorseNumber(anyInt())).thenReturn(false);
        setWinningHorseCommand.execute();
        verify(horseRace, times(1)).setWinningHorse(1);
    }

    @Test
    void execute_InvalidHorseNumber_ExceptionThrown() {
        when(horseRace.checkInValidHorseNumber(anyInt())).thenReturn(true);
        assertThrows(HorseTrackException.class, () -> setWinningHorseCommand.execute());
    }

}
