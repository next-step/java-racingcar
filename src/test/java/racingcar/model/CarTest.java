//package racingcar.model;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.jupiter.api.Test;
//
//class CarTest {
//
//  @Test
//  void moveOrStop_stop() {
//    Car car = new Car();
//    car.moveOrStop(() -> false);
//
//    Car notMovedCar = new Car();
//    assertThat(car).isEqualTo(notMovedCar);
//  }
//
//  @Test
//  void moveOrStop_move() {
//    Car car = new Car();
//    car.moveOrStop(() -> true);
//
//    Car movedCar = new Car(1);
//    assertThat(car).isEqualTo(movedCar);
//  }
//}
