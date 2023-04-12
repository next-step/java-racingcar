package racing.controller.input;

import java.util.Scanner;

/**
 * 사용자 입력 (InputView)
 *     - 책임
 *       - 자동차 대수를 입력받는다.
 *       - 자동차 이동 횟수를 입력받는다.
 */
public class InputView {

  private final Scanner scanner;

  public InputView () {
    scanner = new Scanner(System.in);
  }

  public int scanNumberOfCars() {
    System.out.println("자동차 대수는 몇 대 인가요?");
    return scanner.nextInt();
  }

  public int scanNumberOfMovements() {
    System.out.println("시도할 회수는 몇 회 인가요?");
    return scanner.nextInt();
  }

  public UserInput scanUserInput() {
    int numberOfCars = scanNumberOfCars();
    int numberOfMovements = scanNumberOfMovements();
    return new UserInput(numberOfCars, numberOfMovements);
  }
}
