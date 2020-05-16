package step3;

import java.util.Random;
import java.util.Scanner;

/**
 * 초간단 자동차 경주 게임을 구현한다.
 * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 * 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
 * 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
 */
public class RacingCar {

  public RacingCar () {
    startRace(
      inputCars(),
      inputTryCount()
    );
  }

  public int[] inputCars () {
    Scanner scan = new Scanner(System.in);
    System.out.println("자동차 대수는 몇 대 인가요?");
    int size = Integer.parseInt(scan.nextLine());
    int[] cars = new int[size];
    for (int i = 0; i < size; i++) cars[i] = 0;
    return cars;
  }

  public int inputTryCount () {
    Scanner scan = new Scanner(System.in);
    System.out.println("시도할 회수는 몇 회 인가요?");
    return Integer.parseInt(scan.nextLine());
  }

  public static int getRandom () {
    Random random = new Random();
    return random.nextInt(10);
  }

  public void startRace (int[] cars, int tryCount) {
    System.out.println(getRandom());
  }

  public static void main(String[] args) {
    new RacingCar();
  }
}
