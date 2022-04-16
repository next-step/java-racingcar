package model;

public abstract class ImmutableNumberModel implements NumberModel {

  protected final int value;

  public ImmutableNumberModel(int value) {
    validateValue(value);
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

  abstract public void validateValue(int value);
}
