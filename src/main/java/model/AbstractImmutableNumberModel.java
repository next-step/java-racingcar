package model;

import java.util.Objects;

public abstract class AbstractImmutableNumberModel implements NumberModel {

  protected final int value;

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public int toInt() {
    return this.value;
  }

  public AbstractImmutableNumberModel(int value) {
    validateValue(value);
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractImmutableNumberModel that = (AbstractImmutableNumberModel) o;
    return value == that.value;
  }
}
