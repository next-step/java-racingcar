//package racingcar.model;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//class CarsTest {
//
//  private Cars cars;
//
//  @BeforeEach
//  void setup() {
//    cars = Cars.createCars(5, 0);
//  }
//
//  @Test
//  void makeCars() {
//    Cars testCars = Cars.createCars(10, 0);
//    assertThat(testCars.size()).isEqualTo(10);
//  }
//
//  @Test
//  void move() {
//    cars.move(() -> true);
//
//    Cars movedCars = Cars.createCars(5, 1);
//    assertThat(cars).isEqualTo(movedCars);
//  }
//}
