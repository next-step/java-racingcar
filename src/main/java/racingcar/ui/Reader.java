package racingcar.ui;

public class Reader {

  private static final java.util.Scanner scanner = new java.util.Scanner(System.in);

  public String nextLine() {
    String input = scanner.nextLine();

    if (input.isBlank()) {
      throw new IllegalArgumentException("빈 값은 입력될 수 없습니다");
    }

    return input;
  }
}
