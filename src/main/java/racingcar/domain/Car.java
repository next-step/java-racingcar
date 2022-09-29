package racingcar.domain;

public class Car {

  private int position = 0;
  private static final int criteriaNum = 4;

  public int go(){
    return position++;
  }

  public int getPosition() {
    return position;
  }

  public int getcriteriaNum() {
    return criteriaNum;
  }

}
