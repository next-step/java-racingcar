package racing;

import java.util.Random;

// 자동차 객체
public class Car {

  // 자동차의 현재 위치
  private int position = 0;

  // 자동차의 현재 위치 정보 가져오기
  public int getPosition() {
    return position;
  }

  // 이동
  void move() {

    if (new Random().nextInt(10) >= 4) {
      position++;
    }
  }
}
