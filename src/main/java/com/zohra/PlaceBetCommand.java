package com.zohra;

class PlaceBetCommand implements Command {
    private int horseNumber;
    private int betAmount;
    private Inventory inventory;
    private HorseRace horseRace;

    public PlaceBetCommand(int horseNumber, int betAmount, Inventory inventory, HorseRace horseRace) {
        this.horseNumber = horseNumber;
        this.betAmount = betAmount;
        this.inventory = inventory;
        this.horseRace = horseRace;
    }

    @Override
    public void execute(){
        if (horseRace.checkInValidHorseNumber(horseNumber)) {
            throw new HorseTrackException("Invalid Horse Number: " + horseNumber);
        }
        Horse horse = horseRace.getHorseByNumber(horseNumber);
        if (horse.hasWon()) {
            int odds = horse.getOdds();
            int winnings = odds * betAmount;
            inventory.dispense(winnings);
            displayPayout(horse, winnings);
            displayDispense();
        } else {
            throw new HorseTrackException("No Payout: " + horse.getName());
        }
    }

    private void displayPayout(Horse horse, int amount) {
        System.out.println("Payout:" +" " + horse.getName() +",$" + amount);
    }

    private void displayDispense() {
        System.out.println("\n Dispensing:");
        inventory.displayDispense();
    }
}
