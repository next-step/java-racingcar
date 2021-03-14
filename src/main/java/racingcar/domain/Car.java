package racingcar.domain;

public class Car {

  private static final int MOVEABLE_CRITERIA = 4;

  private int position = 0;
<<<<<<< HEAD
  private final String name;

  public Car(String name) {
    this.name = name;
  }

  public static Car createCar(String name) {
    return new Car(name);
=======

  public static Car createCar() {
    return new Car();
>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))
  }

  public int getPosition() {
    return position;
  }

<<<<<<< HEAD
  public String getName() {
    return name;
  }

=======
>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))
  public void moveCar(int generatedRandomNumber) {
    if(isMoveable(generatedRandomNumber))
      this.position++;
  }

  private boolean isMoveable(int generatedRandomNumber) {
    return generatedRandomNumber >= MOVEABLE_CRITERIA;
  }

<<<<<<< HEAD
  public String printNameWithCurrentPosition() {
    String position = positionToLine();
    return this.name + " : " + position;
  }

  private String positionToLine() {
=======
  public String positionToLine() {
>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i <= position; i++){
      sb.append('-');
    }
    return sb.toString();
  }
}
