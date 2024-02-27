package com.zohra;

import java.util.Objects;

public class Denomination {
  private int value;
  private int count;

  public Denomination(int value, int count) {
    this.value = value;
    this.count = count;
  }

  public int getValue() {
    return value;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Denomination that = (Denomination) o;
    return value == that.value && count == that.count;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, count);
  }
}
