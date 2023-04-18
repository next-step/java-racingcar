package study.domain.racingGame;

public class RacingGame {

  private Cars cars;
  private int gameCnt;

  private GameConsole console;

  public RacingGame() {
    this.cars = new Cars();
  }

  public void ready(int gameCnt, int carNum) {
    this.gameCnt = gameCnt;
    this.cars.addCars(carNum);
  }

  public boolean isReady() {
    return gameCnt > 0 || cars.getTotalCarsCount() > 0;
  }

  public boolean isFinish() {
    return gameCnt <= 0 && cars.getTotalCarsCount() > 0;
  }


  public void race() {
    if (!isReady()) {
      throw new RuntimeException("게임 준비가 되지 않았습니다.");
    }

    this.cars.moveAll();
    this.gameCnt--;
  }

  public void printCarsDistance(GameScreen screen) {
    this.cars.forEach(car ->
        screen.print(convertCarDistanceToDash(car.getTotalDistance())));
    screen.print("");
  }

  private String convertCarDistanceToDash(int carDistance) {
    String result = "";
    for (int i = 0; i < carDistance; i++) {
      result += "-";
    }
    return result;
  }
}
