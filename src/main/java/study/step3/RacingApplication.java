package study.step3;

public class RacingApplication {

  static final private String QUESTION_NUM_OF_CARS = "자동차 대수는 몇 대 인가요?";
  static final private String QUESTION_NUM_OF_ROUNDS = "시도할 회수는 몇 회 인가요?";

  public static void main(String[] args) {
    int numOfCars = InputView.startInput(QUESTION_NUM_OF_CARS);
    int numOfRaces = InputView.startInput(QUESTION_NUM_OF_ROUNDS);

    Racing.play(CarFactory.createCars(numOfCars), numOfRaces);
  }
}
