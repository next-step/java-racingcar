package racing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

  private List<RacingCar> carList;

  private Random random = new Random();

  /**
   * 입력 받은 값으로 자동차와 게임 턴 설정 메서드
   */
  public List<RacingCar> setUp(int carCount) {
    carList = new ArrayList<>();
    for (int i = 0; i < carCount; i++) {
      carList.add(new RacingCar(0));
    }
    return carList;
  }

  /**
   * 자동차가 이동할 랜덤값 생성 메서드
   */
  public List<Integer> createRandomValue() {
    List<Integer> randomValue = new ArrayList<>();
    for (int i = 0; i < carList.size(); i++) {
      randomValue.add(random.nextInt(10));
    }
    return randomValue;
  }

  /**
   * 조건에 따라 자동차를 이동시켜주는 메서드
   */
  public List<RacingCar> moveAndStop(List<Integer> randomValue) {
    for (int i = 0; i < carList.size(); i++) {
      carList.get(i).move(randomValue.get(i));
    }
    return carList;
  }


}
