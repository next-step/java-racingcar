package step3;

public class RacingCarGame {
  private Cars cars;
  private int numberOfReps;

  public RacingCarGame() {
    this.cars = new Cars();
  }

  public void getRepetitionReady() {
    final String MESSAGE_ASKING_REPS = "시도할 횟수는 몇 회 인가요?";
    this.numberOfReps = Integer.parseInt(InputView.getInput(MESSAGE_ASKING_REPS));
  }

  public void getCarsReady() {
    final String MESSAGE_ASKING_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    for (String name : InputView.getInput(MESSAGE_ASKING_CARS).split(",")) {
      this.cars.addCar(new Car(name));
    }
  }

  public void startRacing() {
    ResultView.printExecutionComment();
    for (int i = 0; i < this.numberOfReps; i++) {
      cars.moveAllCars();
      ResultView.printCurrentStatus(this.cars);
    }
  }

  public void displayResult() {
    ResultView.printWinners(this.cars.leadingCars());
  }
}
