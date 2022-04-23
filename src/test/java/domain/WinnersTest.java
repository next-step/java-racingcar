package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinnersTest {

  private static final String CAR_NAME_1 = "name1";
  private static final String CAR_NAME_2 = "name2";
  private static final String CAR_NAME_3 = "name3";
  private static final String CAR_NAME_4 = "name4";
  private static final String CAR_NAME_5 = "name5";

  @Test
  void findWinners_단수우승자_성공() {
    Car car1 = new Car(CAR_NAME_1, 0);
    Car car2 = new Car(CAR_NAME_2, 1);
    Car car3 = new Car(CAR_NAME_3, 1);
    Car car4 = new Car(CAR_NAME_4, 1);
    Car car5 = new Car(CAR_NAME_5, 2);

    Cars cars = new Cars(List.of(car1, car2, car3, car4, car5));
    Winners winners = cars.findWinners();

    assertThat(winners.toString().contains(CAR_NAME_1)).isFalse();
    assertThat(winners.toString().contains(CAR_NAME_2)).isFalse();
    assertThat(winners.toString().contains(CAR_NAME_3)).isFalse();
    assertThat(winners.toString().contains(CAR_NAME_4)).isFalse();
    assertThat(winners.toString().contains(CAR_NAME_5)).isTrue();
  }
  @Test
  void findWinners_복수우승자_성공() {
    Car car1 = new Car(CAR_NAME_1, 0);
    Car car2 = new Car(CAR_NAME_2, 1);
    Car car3 = new Car(CAR_NAME_3, 2);
    Car car4 = new Car(CAR_NAME_4, 1);
    Car car5 = new Car(CAR_NAME_5, 2);

    Cars cars = new Cars(List.of(car1, car2, car3, car4, car5));
    Winners winners = cars.findWinners();

    assertThat(winners.toString().contains(CAR_NAME_1)).isFalse();
    assertThat(winners.toString().contains(CAR_NAME_2)).isFalse();
    assertThat(winners.toString().contains(CAR_NAME_3)).isTrue();
    assertThat(winners.toString().contains(CAR_NAME_4)).isFalse();
    assertThat(winners.toString().contains(CAR_NAME_5)).isTrue();
  }
}
