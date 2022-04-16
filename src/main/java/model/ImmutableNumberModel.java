package model;

public abstract class ImmutableNumberModel implements NumberModel {

  protected final int value;

  public int getValue() {
    return value;
  }

  public ImmutableNumberModel(int value) {
    validateValue(value);
    this.value = value;
  }
}
