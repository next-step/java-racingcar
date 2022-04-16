package model;

public abstract class abstractNumberModel implements NumberModel{

  protected int value;

  public abstractNumberModel(int value) {
    validateValue(value);
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

  abstract public void validateValue(int value);
}
