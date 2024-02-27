package com.zohra;

import java.util.Arrays;
import java.util.List;

public class HorseRace {
  private final List<Horse> horseList;

  public HorseRace() {
    horseList =
        Arrays.asList(
            new Horse("That Darn Gray Cat", 5, true),
            new Horse("Fort Utopia", 10, false),
            new Horse("Count Sheep", 9, false),
            new Horse("Ms Traitour", 4, false),
            new Horse("Real Princess", 3, false),
            new Horse("Pa Kettle", 5, false),
            new Horse("Gin Stinger", 6, false));
  }

  public void display() {
    horseList.forEach(
        horse ->
            System.out.println(
                (horseList.indexOf(horse) + 1)
                    + ","
                    + horse.getName()
                    + ","
                    + horse.getOdds()
                    + ","
                    + (horse.hasWon() ? "won" : "lost")));
  }

  public boolean checkInValidHorseNumber(int horseNumber) {
    return (horseNumber < 1 || horseNumber > horseList.size());
  }

  public void setWinningHorse(int horseNumber) {
    Horse horse = horseList.get(horseNumber - 1);
    horse.setWon(true);
    horseList.set(horseNumber - 1, horse);
  }

  public Horse getHorseByNumber(int horseNumber) {
    return horseList.get(horseNumber - 1);
  }
}
