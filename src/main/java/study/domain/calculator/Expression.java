package study.domain.calculator;


import java.util.Arrays;

public class Expression {

  private final String CUSTOM_SEPARATOR_PREFIX = "//";
  private final String CUSTOM_SEPARATOR_PREFIX_SUFFIX = "\n";
  private String expressionStr;
  private SeparatorList separatorList;


  public Expression(String expressionStr) {
    this.expressionStr = expressionStr;
    this.separatorList = new SeparatorList();
  }

  public int[] extractOnlyNum() {
    if (isEmpty()) {
      return getDefaultNumArr();
    }
    String customSeparator = findCustomSeparator();
    if (customSeparator != null) {
      removeCustomSeparator(customSeparator);
      this.separatorList.add(customSeparator);
    }
    return this.splitExpressionUseSeparatorList();
  }

  private boolean isNumeric(String strNum) {
    if (strNum == null) {
      return false;
    }
    try {
      Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }

  private int[] splitExpressionUseSeparatorList() {
    return Arrays.stream(this.expressionStr.split(this.separatorList.makeSeparatorRegex()))
        .mapToInt(strNum -> parseInt(strNum))
        .toArray();
  }

  private int parseInt(String strNum) {
    if (!isNumeric(strNum)) {
      throw new RuntimeException("숫자가 아닌 값이 수식에 있습니다.");
    }
    return Integer.parseInt(strNum);
  }

  private void removeCustomSeparator(String customSeparator) {
    String removeStr = CUSTOM_SEPARATOR_PREFIX + customSeparator + CUSTOM_SEPARATOR_PREFIX_SUFFIX;
    this.expressionStr = this.expressionStr.replace(removeStr, "");
  }

  private int[] getDefaultNumArr() {
    return new int[]{0};
  }

  private boolean isEmpty() {
    return this.expressionStr == null || this.expressionStr.isEmpty();
  }

  private String findCustomSeparator() {
    int prefixIdx =
        this.expressionStr.indexOf(CUSTOM_SEPARATOR_PREFIX) + CUSTOM_SEPARATOR_PREFIX.length() - 1;
    int suffix = this.expressionStr.indexOf(CUSTOM_SEPARATOR_PREFIX_SUFFIX);
    boolean isOneCharter = suffix - prefixIdx == 2;
    if (prefixIdx < 0 || suffix < 0 || suffix < prefixIdx || !isOneCharter) {
      return null;
    }
    return this.expressionStr.substring(prefixIdx + 1, suffix);
  }
}
