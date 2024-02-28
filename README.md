# Horse Track Race ATM

This application, developed in Java 17, utilizes the command design pattern to handle user commands effectively.

## Classes

### HorseTrackCLI
This class is responsible for handling user input and interacting with other components of the application.

### Inventory
Manages the inventory of bills in the ATM.

### HorseRace
Manages the list of horses.

### Command
An interface defining the Command pattern for handling user commands.

### Concrete Command Classes
1. **RestockCommand**: Restocks the ATM inventory.
2. **QuitCommand**: Quits the application.
3. **SetWinningHorseCommand**: Sets the winning horse for the race.
4. **PlaceBetCommand**: Places a bet on a horse.

### Horse
Model class for horse

### Denomination
Model class for currency value and count

## Usage
To run the application, simply execute the `Main` class. Follow the prompts to interact with the Horse Track Race ATM.

## Dependencies
- Java 17


---
Developed by Zohra
