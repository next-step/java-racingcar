package racingcar.model;

import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class Car {

  private static final int INITIAL_POSITION = 1;

  private int carNo;
  private int position;

  private Random random;


  public Car(int carNo) {
    this.carNo = carNo;
    this.position = INITIAL_POSITION;

    this.random = new Random();
  }

  /**
   * 현재 위치 + 1
   */
  public void move() {
    if (enableMoveForward()) this.position += 1;
  }

  /**
   * 경주가 끝난 후 새로운 경주를 하기 전에 position reset
   */
  public void resetPosition() {
    this.position = INITIAL_POSITION;
  }

  /**
   * random 값이 4 이상이면 true 반환
   * @return
   */
  private boolean enableMoveForward() {
    int value = random.nextInt(10);
    if (value > 4) return true;

    return false;
  }


  /**
   * 현재 차의 위치를 "-"로 표시
   * ex) 현재 위치가 5이면, "-----"
   * @return
   */
  public void showCurrentPosition() {
    System.out.println(this.toString());
  }

  @Override
  public String toString() {
    return IntStream.range(INITIAL_POSITION, position).mapToObj(pos -> "-").collect(joining());
  }
}
