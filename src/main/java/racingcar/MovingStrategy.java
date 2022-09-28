package racingcar;

public class MovingStrategy {

  private boolean isMoveAble(int randomInt, int criteriaNum) {
    return randomInt >= criteriaNum;
  }

  public String moveCar(int randomint, String positionView, int criteriaNum) {
    if (isMoveAble(randomint, criteriaNum)) {
      positionView += "-";
    }
    return positionView;
  }

}
