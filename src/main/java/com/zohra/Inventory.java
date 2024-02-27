package com.zohra;

import java.util.Arrays;
import java.util.List;

public class Inventory {
  private List<Denomination> denominationList;
  private List<Denomination> dispenseList;
  private int totalAmount;

  public Inventory() {
    denominationList =
        Arrays.asList(
            new Denomination(1, 10),
            new Denomination(5, 10),
            new Denomination(10, 10),
            new Denomination(20, 10),
            new Denomination(100, 10));
    dispenseList =
        Arrays.asList(
            new Denomination(1, 0),
            new Denomination(5, 0),
            new Denomination(10, 0),
            new Denomination(20, 0),
            new Denomination(100, 0));
    calculateTotalAmount();
  }

  public List<Denomination> getDenominationList() {
    return denominationList;
  }

  public void display() {
    print(denominationList);
  }

  private void calculateTotalAmount() {
    totalAmount =
        denominationList.stream()
            .mapToInt(denomination -> denomination.getCount() * denomination.getValue())
            .sum();
  }

  private boolean hasSufficientFunds(int payoutAmount) {
    return payoutAmount <= totalAmount;
  }

  public void restock() {
    denominationList.forEach(denomination -> denomination.setCount(10));
    calculateTotalAmount();
  }

  public void dispense(int payoutAmount) {
    if (hasSufficientFunds(payoutAmount)) {
      for (int i = denominationList.size() - 1; i >= 0; i--) {
        int value = denominationList.get(i).getValue();
        int count = Math.min(payoutAmount / value, denominationList.get(i).getCount());
        dispenseList.set(i, new Denomination(value, count));
        denominationList.set(
            i, new Denomination(value, denominationList.get(i).getCount() - count));
        payoutAmount -= count * value;
      }
      calculateTotalAmount();
    } else {
      throw new HorseTrackException("Insufficient Funds: " + "$" + payoutAmount);
    }
  }

  public void displayDispense() {
    print(dispenseList);
  }

  private void print(List<Denomination> denominationList) {
    denominationList.forEach(
        denomination ->
            System.out.println("$" + denomination.getValue() + " " + denomination.getCount()));
  }
}
