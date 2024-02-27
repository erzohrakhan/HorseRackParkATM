package com.zohra;

public class Main {
    public static void main(String[] args) {
        HorseRace horseRace = new HorseRace();
        Inventory inventory = new Inventory();

        HorseTrackCLI horseTrackCLI = new HorseTrackCLI(horseRace, inventory);
        horseTrackCLI.start();
    }
}