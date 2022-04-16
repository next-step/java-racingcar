package model;

public interface NumberModel {

  int getValue();
  void validateValue(int value);

  default void validate() {
    validateValue(getValue());
  }
}
