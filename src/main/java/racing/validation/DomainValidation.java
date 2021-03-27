package racing.validation;

public final class DomainValidation {

  private DomainValidation() {
  }

  public static void checkExceedStringLength(String str, int limitLength) {
    checkExceedStringLength(str, limitLength, "Column length limit exceeded.");
  }

  public static void checkExceedStringLength(String str, int limitLength, String message) {
    checkExceedStringLength(str.length(), limitLength, message);
  }

  public static void checkExceedStringLength(int length, int limitLength, String message) {
    if (length > limitLength) {
      throw new IllegalArgumentException(message);
    }
  }
}
