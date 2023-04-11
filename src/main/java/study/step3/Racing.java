package study.step3;

public class Racing {

  static final private String QUESTION_NUM_OF_CARS = "자동차 대수는 몇 대 인가요?";
  static final private String QUESTION_NUM_OF_ROUNDS = "시도할 회수는 몇 회 인가요?";

  private Racing() {
  }

  static void start() {
    int numOfCars = InputView.startInput(QUESTION_NUM_OF_CARS);
    int numOfRaces = InputView.startInput(QUESTION_NUM_OF_ROUNDS);

    playRacing(numOfCars, numOfRaces);
  }

  private static void playRacing(int numOfCars, int numOfRaces) {
    Car[] cars = CarManager.createCars(numOfCars);

    for (int i = 0; i < numOfRaces; i++) {
      CarManager.moveCars(cars);
      ResultView.printResult(i + 1, cars);
    }
  }
}
