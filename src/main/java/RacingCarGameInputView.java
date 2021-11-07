import java.util.Scanner;

public class RacingCarGameInputView {

  private static final Scanner scanner = new Scanner(System.in);

  private RacingCarGameInputView() { }

  public static int getCarAmount() {
    System.out.println("자동차 대수는 몇 대 인가요?");
    return scanner.nextInt();
  }

  public static int getChanceAmount() {
    System.out.println("시도할 회수는 몇 회 인가요?");
    return scanner.nextInt();
  }

}
