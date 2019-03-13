package racing;

// 자동차 객체
public class Car {

  private RandomGenerator randomGenerator;

  // 자동차의 현재 위치
  protected int position = 0;

  // 자동차 이름
  private String name;

  public Car(RandomGenerator randomGenerator, String name) {
    this.randomGenerator = randomGenerator;
    this.name = name;
  }

  // 자동차의 현재 위치 정보 가져오기
  public int getPosition() {
    return position;
  }

  // 자동차의 이름 가져오기
  public String getName() {
    return name;
  }

  // 이동
  void move(int minNumber) {

    if (randomGenerator.isMoving(minNumber)) {
      position++;
    }
  }
}
