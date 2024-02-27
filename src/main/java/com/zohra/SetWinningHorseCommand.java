package com.zohra;

class SetWinningHorseCommand implements Command {
  private int horseNumber;
  private HorseRace horseRace;

  public SetWinningHorseCommand(int horseNumber, HorseRace horseRace) {
    this.horseNumber = horseNumber;
    this.horseRace = horseRace;
  }

  @Override
  public void execute() {
    if (horseRace.checkInValidHorseNumber(horseNumber)) {
      throw new HorseTrackException("Invalid Horse Number: " + horseNumber);
    }
    horseRace.setWinningHorse(horseNumber);
  }
}
