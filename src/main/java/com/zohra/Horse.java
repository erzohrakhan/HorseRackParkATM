package com.zohra;

import java.util.Objects;

public class Horse {
  private String name;
  private int odds;
  private boolean won;

  public Horse(String name, int odds, boolean won) {
    this.name = name;
    this.odds = odds;
    this.won = won;
  }

  public String getName() {
    return name;
  }

  public int getOdds() {
    return odds;
  }

  public boolean hasWon() {
    return won;
  }

  public void setWon(boolean won) {
    this.won = won;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Horse horse = (Horse) o;
    return odds == horse.odds && won == horse.won && Objects.equals(name, horse.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, odds, won);
  }
}
