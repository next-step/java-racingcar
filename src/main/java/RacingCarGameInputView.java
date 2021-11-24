import java.util.Scanner;

public class RacingCarGameInputView {

  private static final Scanner scanner = new Scanner(System.in);
  private static final String DELIMITER = Constants.STRING_DELIMITER;

  private RacingCarGameInputView() { }

  public static int inputRoundAmount() {
    System.out.println("시도할 회수는 몇 회 인가요?");
    return scanner.nextInt();
  }

  public static String[] inputCarNames() {
    System.out.println(String.format("경주할 자동차 이름을 입력하세요(이름은 쉼표(%s)를 기준으로 구분).", DELIMITER));
    String inputString = scanner.next();
    return inputString.split(DELIMITER);
  }

}
