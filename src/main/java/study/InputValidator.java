package study;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {

  final private String inputValue;
  private Set<String> operator;

  public InputValidator(String str) throws IllegalArgumentException {
    if (str == null) {
      throw new IllegalArgumentException("Input cannot be null.");
    }
    this.inputValue = str.trim();
    this.operator = new HashSet<>(Arrays.asList("+","-","*","/"));
  }

  public InputValidator checkHasBlank() throws IllegalArgumentException {
    if ("".equals(inputValue)) {
      throw new IllegalArgumentException("Input cannot be blank.");
    }
    return this;
  }

  public InputValidator checkHasWrongOperator() throws IllegalArgumentException {
    for (String str : this.inputValue.split(" ")) {
      if (!isNumberString(str) && !operator.contains(str)) {
        throw new IllegalArgumentException("Input contains wrong operators.");
      }
    }
    return this;
  }

  public InputValidator checkHasAllOperator() throws IllegalArgumentException {
    for (String str : this.inputValue.split(" ")) {
      if (!isNumberString(str) && operator.contains(str)) {
        operator.remove(str);
      }
    }

    if (operator.isEmpty())
      return this;

    throw new IllegalArgumentException("Some operators are missing.");
  }

  public String getValue() {
    return inputValue;
  }

  private boolean isNumberString(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (NumberFormatException nfe) {
      return false;
    }
  }
}
