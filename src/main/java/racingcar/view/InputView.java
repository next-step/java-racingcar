package racingcar.view;

import racingcar.exception.GameNotPreparedException;
import racingcar.model.Car;
import racingcar.util.RandomUtil;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

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
  private RandomUtil random;

  private int rounds = -1;
  private int cars = -1;

  public InputView() {
    this.scanner = new Scanner(System.in);
    this.random = new RandomUtil();
  }

  public int getRounds() {
    if (this.rounds == -1) throw new GameNotPreparedException("prepare method를 통해 Game에 필요한 질문에 먼저 답해주세요.");
    return rounds;
  }

  public int getCars() {
    if (this.rounds == -1) throw new GameNotPreparedException("prepare method를 통해 Game에 필요한 질문에 먼저 답해주세요.");
    return cars;
  }

  public List<Car> prepare() {
    askNumberOfCars();
    askNumberOfRounds();
    List<Car> cars = generatePlayers();
    return cars;
  }

  void askNumberOfCars() {
    System.out.println("자동차 대수는 몇 대 인가요? \n");
    this.cars = scanner.nextInt();
  }

  void askNumberOfRounds() {
    System.out.println("시도할 회수는 몇 회 인가요? \n");
    this.rounds = scanner.nextInt();
  }

  private List<Car> generatePlayers() {
    return range(0, this.cars)
      .mapToObj((carNo) -> new Car(carNo, random))
      .collect(Collectors.toList());
  }

}
