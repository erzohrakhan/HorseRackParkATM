package com.zohra;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HorseRaceTest {
  private HorseRace horseRace;

  @BeforeEach
  void setup() {
    horseRace = new HorseRace();
  }

  @Test
  void testCheckInvalidHorseNumber() {

    // Test with invalid horse number
    assertTrue(horseRace.checkInValidHorseNumber(0));
    assertTrue(horseRace.checkInValidHorseNumber(8));
    assertTrue(horseRace.checkInValidHorseNumber(-1));

    // Test with valid horse number
    assertFalse(horseRace.checkInValidHorseNumber(1));
    assertFalse(horseRace.checkInValidHorseNumber(4));
    assertFalse(horseRace.checkInValidHorseNumber(7));
  }

  @Test
  void testSetWinningHorse() {
    horseRace.setWinningHorse(3);

    assertTrue(horseRace.getHorseByNumber(3).hasWon());
    assertTrue(horseRace.getHorseByNumber(1).hasWon());
    assertFalse(horseRace.getHorseByNumber(2).hasWon());
    assertFalse(horseRace.getHorseByNumber(4).hasWon());
  }

  @Test
  void testGetHorseByNumber() {

    assertEquals("That Darn Gray Cat", horseRace.getHorseByNumber(1).getName());
    assertEquals("Count Sheep", horseRace.getHorseByNumber(3).getName());
    assertEquals("Gin Stinger", horseRace.getHorseByNumber(7).getName());

    // Test getting horse by invalid number (out of bounds)
    assertThrows(IndexOutOfBoundsException.class, () -> horseRace.getHorseByNumber(8));
  }
}
