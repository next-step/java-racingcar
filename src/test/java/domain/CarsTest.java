package domain;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.StringJoiner;
import org.junit.jupiter.api.Test;

public class CarsTest {

  private static final String CAR_RAW_NAMES_DELIMITER = ",";
  private static final String CAR_NAME_1 = "name1";
  private static final String CAR_NAME_2 = "name2";
  private static final String CAR_NAME_3 = "name3";
  private static final String CAR_NAME_4 = "name4";
  private static final String CAR_NAME_5 = "name5";


  @Test
  void Cars_생성_성공() {
    Car car1 = new Car(CAR_NAME_1, 1);
    Car car2 = new Car(CAR_NAME_2, 1);
    assertDoesNotThrow(() -> new Cars(List.of(car1, car2)));
  }

  @Test
  void Cars_생성_실패() {
    assertThrows(IllegalArgumentException.class, () -> new Cars(emptyList()));
  }

  @Test
  void fromString_성공() {
    String rawCarNames = new StringJoiner(CAR_RAW_NAMES_DELIMITER)
        .add(CAR_NAME_1)
        .add(CAR_NAME_2)
        .add(CAR_NAME_3)
        .add(CAR_NAME_4)
        .add(CAR_NAME_5)
        .toString();

    assertDoesNotThrow(() -> Cars.fromString(rawCarNames));
  }

  @Test
  void fromString_실패() {
    assertThrows(IllegalArgumentException.class, () -> Cars.fromString(" , "));
  }

  @Test
  void findWinners_단수우승자_성공() {
    Car car1 = new Car(CAR_NAME_1, 0);
    Car car2 = new Car(CAR_NAME_2, 1);
    Car car3 = new Car(CAR_NAME_3, 1);
    Car car4 = new Car(CAR_NAME_4, 1);
    Car car5 = new Car(CAR_NAME_5, 2);

    Cars cars = new Cars(List.of(car1, car2, car3, car4, car5));
    Winners winners = new Winners(List.of(CAR_NAME_5));

    assertThat(cars.findWinners().equals(winners)).isTrue();
  }

  @Test
  void findWinners_복수우승자_성공() {
    Car car1 = new Car(CAR_NAME_1, 0);
    Car car2 = new Car(CAR_NAME_2, 1);
    Car car3 = new Car(CAR_NAME_3, 2);
    Car car4 = new Car(CAR_NAME_4, 1);
    Car car5 = new Car(CAR_NAME_5, 2);

    Cars cars = new Cars(List.of(car1, car2, car3, car4, car5));
    Winners winners = new Winners(List.of(CAR_NAME_3, CAR_NAME_5));

    assertThat(cars.findWinners().equals(winners)).isTrue();
  }

  @Test
  void markingPositions_성공() {
    Car car1 = new Car(CAR_NAME_1, 2);
    Car car2 = new Car(CAR_NAME_2, 1);
    Car car3 = new Car(CAR_NAME_3, 0);
    Cars cars = new Cars(List.of(car1, car2, car3));

    List<String> positionMarkList = cars.markingPositions();

    assertThat(positionMarkList.get(0)).isEqualTo(car1.markPosition());
    assertThat(positionMarkList.get(1)).isEqualTo(car2.markPosition());
    assertThat(positionMarkList.get(2)).isEqualTo(car3.markPosition());
  }
}
