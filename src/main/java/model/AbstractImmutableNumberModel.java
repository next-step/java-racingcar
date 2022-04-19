package model;

public abstract class AbstractImmutableNumberModel implements NumberModel {

  protected final int value;

  public int getValue() {
    return value;
  }

  public AbstractImmutableNumberModel(int value) {
    validateValue(value);
    this.value = value;
  }
}
