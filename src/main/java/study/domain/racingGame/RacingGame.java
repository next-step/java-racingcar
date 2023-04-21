package study.domain.racingGame;

public class RacingGame {

  private Cars cars;

  private GameBoard gameBoard;
  private int gameCnt;

  public void ready(int gameCnt, Cars cars) {
    this.gameCnt = gameCnt;
    this.cars = cars;
    gameBoard = new GameBoard(cars);
  }

  public boolean isReady() {
    return this.gameCnt > 0 && this.cars != null && this.cars.getTotalCarsCount() > 0;
  }

  public boolean isFinish() {
    return this.gameCnt <= 0 && this.cars.getTotalCarsCount() > 0;
  }


  public GameBoard race() {
    if (!isReady()) {
      throw new RuntimeException("게임 준비가 되지 않았습니다.");
    }

    this.cars.moveAll();
    this.gameBoard.updateResult(this.cars);
    this.gameCnt--;
    return this.gameBoard.clone();
  }

  public CarNames getWinnerNames() {
    return this.cars.getMaxDistanceCarNames();
  }
}
