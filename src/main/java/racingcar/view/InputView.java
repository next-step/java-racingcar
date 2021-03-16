package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class InputView implements AutoCloseable {

  private final Scanner scanner;
  private boolean closed;

  public InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  @Override
  public void close() {
    if (closed) {
      return;
    }
    scanner.close();
    closed = true;
  }

  public List<Car> inputCarNames() {
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분하고, 최대 5자입니다.)");
    Printer.printPrompt();

    String[] namesArray = scanner.nextLine().replaceAll("\\s+", "").split(",");
    return Arrays.stream(namesArray).map(Car::create).collect(Collectors.toList());
  }

  public int inputRound() {
    return inputInteger("시도할 회수", "회");
  }

  private boolean isPositive(int number) {
    return number > 0;
  }

  private int inputInteger(String message, String unit) {
    System.out.println(message + "는 몇 " + unit + " 인가요?");
    Printer.printPrompt();

    int carCount = scanner.nextInt();
    if (isPositive(carCount)) {
      return carCount;
    }
    throw new IllegalArgumentException(message + "는 양수여야 합니다.");
  }

}
