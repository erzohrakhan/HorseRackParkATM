package com.zohra;

public class RestockCommand implements Command {
  private Inventory inventory;

  public RestockCommand(Inventory inventory) {
    this.inventory = inventory;
  }

  @Override
  public void execute() {
    inventory.restock();
  }
}
