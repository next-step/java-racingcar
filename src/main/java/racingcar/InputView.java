package racingcar;

import java.util.Scanner;

/**
 * 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 *
 * 자동차 대수는 몇 대 인가요?
 * -> 3
 * 시도할 회수는 몇 회 인가요?
 * -> 5
 */
public class InputView {

  private Scanner scanner;

  public InputView() {
    this.scanner = new Scanner(System.in);
  }

  public void askQuestions() {
    int cars = askNumberOfCars();
    int rounds = askNumberOfRounds();
  }

  int askNumberOfCars() {

    System.out.println("자동차 대수는 몇 대 인가요? \n");
    int cars = scanner.nextInt();
    return cars;
  }

  int askNumberOfRounds() {

    System.out.println("시도할 회수는 몇 회 인가요?");
    int rounds = scanner.nextInt();
    return rounds;
  }



}
