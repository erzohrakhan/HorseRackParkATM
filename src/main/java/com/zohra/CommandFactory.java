package com.zohra;

class CommandFactory {
  public static Command createCommand(String input, Inventory inventory, HorseRace horseRace) {
    String[] tokens = input.split("\\s+");
    if (tokens.length == 0) {
      return null;
    }
    String commandType = tokens[0].toLowerCase();
    switch (commandType) {
      case "r":
        return new RestockCommand(inventory);
      case "q":
        return new QuitCommand();
      case "w":
        if (tokens.length == 2) {
          try {
            int horseNumber = Integer.parseInt(tokens[1]);
            return new SetWinningHorseCommand(horseNumber, horseRace);
          } catch (NumberFormatException e) {
            return null;
          }
        }
      default:
        if (tokens.length == 2) {
          String betAmount = tokens[1];
          try {
            int horseNumber = Integer.parseInt(tokens[0]);
            int betAmountValue = Integer.parseInt(tokens[1]);
            if (betAmountValue <= 0) return null;
            return new PlaceBetCommand(horseNumber, betAmountValue, inventory, horseRace);
          } catch (NumberFormatException e) {
            if (betAmount.contains(".")) {
              throw new HorseTrackException("Invalid Bet:" + " " + betAmount);
            }
            // return null;
          }
        }
    }
    return null;
  }
}
