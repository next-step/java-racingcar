package study1.racing;

import java.util.List;

public class Race {
  private final List<Car> cars;
  private final int round;

  public Race(List<Car> cars, int round) {
    this.cars = cars;
    this.round = round;
  }
  
  public static Race setRace (int participant, int round) {
    // participant 에 따라서 race 를 개최하고 return
    return null;
  }

  public void run () {
    // for round, for car.size
    // map, foreach 로 nested 루프 구현해보기
  }
}
