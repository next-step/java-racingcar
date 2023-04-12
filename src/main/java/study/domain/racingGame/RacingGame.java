package study.domain.racingGame;

public class RacingGame {

  private final String INPUT_CAR_NUM_TXT = "자동차 대수는 몇 대 인가요?";
  private final String INPUT_CAR_MOVE_CNT_TXT = "시도할 회수는 몇 회 인가요?";
  private Cars cars;
  private int carMoveCnt;

  private GameConsole console;

  public RacingGame() {
    console = new GameConsole();
    cars = new Cars();

  }

  public void ready() {
    cars.addCars(inputCarNum());
    carMoveCnt = inputCarMoveCnt();
  }

  public boolean isReady() {
    return carMoveCnt > 0 || cars.findTotalCarsCount() > 0;
  }

  public boolean isFinish() {
    return carMoveCnt <= 0 && cars.findTotalCarsCount() > 0;
  }

  public void start() {
    if (!isReady()) {
      throw new RuntimeException("게임 준비가 되지 않았습니다.");
    }
    race();
  }

  private void race() {
    while (carMoveCnt-- > 0) {
      cars.moveAll();
      printCarsDistance();
      console.print("");
    }
  }

  private void printCarsDistance() {
    cars.forEach(car ->
        console.print(convertCarDistanceToDash(car.findTotalDistance())));
  }

  private String convertCarDistanceToDash(int carDistance) {
    String result = "";
    for (int i = 0; i < carDistance; i++) {
      result += "-";
    }
    return result;
  }

  private int inputCarNum() {
    this.console.print(INPUT_CAR_NUM_TXT);
    return this.console.inputInt();
  }

  private int inputCarMoveCnt() {
    console.print(INPUT_CAR_MOVE_CNT_TXT);
    return console.inputInt();
  }
}
