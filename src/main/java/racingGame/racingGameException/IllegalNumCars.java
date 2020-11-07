package racingGame.racingGameException;

public class IllegalNumCars extends IllegalArgumentException {

  public IllegalNumCars() {
    super("너무 적은 수의 차량입니다.");
  }
}
