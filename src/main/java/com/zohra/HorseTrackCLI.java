package com.zohra;

import java.util.Scanner;

public class HorseTrackCLI {
  HorseRace horseRace;
  Inventory inventory;

  public HorseTrackCLI(HorseRace horseRace, Inventory inventory) {
    this.horseRace = horseRace;
    this.inventory = inventory;
  }

  public void start() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      displayInventory();
      displayHorseRace();
      String input = scanner.nextLine().trim();
      if (input.isEmpty()) {
        continue;
      }
      try {
        handleCommand(input);
      } catch (HorseTrackException horseTrackException) {
        System.out.println(horseTrackException.getMessage());
      }
    }
  }

  private void handleCommand(String input) {
    Command command = CommandFactory.createCommand(input, inventory, horseRace);
    if (command != null) {
      command.execute();
    } else {
      throw new HorseTrackException("Invalid Command: " + input);
    }
  }

  private void displayInventory() {
    System.out.println("Inventory:");
    inventory.display();
  }

  private void displayHorseRace() {
    System.out.println("Horses:");
    horseRace.display();
  }
}
