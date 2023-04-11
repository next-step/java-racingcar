package study.step3;

public class Racing {

  static final private String QUESTION_NUM_OF_CARS = "자동차 대수는 몇 대 인가요?";
  static final private String QUESTION_NUM_OF_ROUNDS = "시도할 회수는 몇 회 인가요?";

  private Racing() {
  }

  static void start() {
    int numOfCars = InputView.startInput(QUESTION_NUM_OF_CARS);
    int numOfRaces = InputView.startInput(QUESTION_NUM_OF_ROUNDS);

    playRacing(numOfRaces, createCars(numOfCars));
  }

  private static Car[] createCars(int numOfCars) {
    return CarManager.createCars(numOfCars);
  }

  private static void playRacing(int numOfRaces, Car[] cars) {
    for (int raceNum = 0; raceNum < numOfRaces; raceNum++) {
      CarManager.moveCars(cars);
      ResultView.printResult(raceNum, cars);
    }
  }
}
