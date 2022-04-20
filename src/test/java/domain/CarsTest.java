package domain;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {


  private static final String CAR_NAME_1 = "name1";
  private static final String CAR_NAME_2 = "name2";
  private static final String CAR_NAME_3 = "name3";
  private static final String CAR_NAME_4 = "name4";
  private static final String CAR_NAME_5 = "name5";
  private static final List<String> CAR_NAMES = List.of(
      CAR_NAME_1, CAR_NAME_2, CAR_NAME_3, CAR_NAME_4, CAR_NAME_5
  );


  @Test
  void Cars_생성_성공() {
    assertDoesNotThrow(() -> new Cars(CAR_NAMES));
  }

  @Test
  void Cars_생성_실패() {
    assertThrows(IllegalArgumentException.class, () -> new Cars(emptyList()));
  }

  @Test
  void CarInfo_리스트_획득_성공() {
    List<CarInfo> carInfoList = new Cars(CAR_NAMES).getCarsInfo();
    for (int i = 0; i < carInfoList.size(); i++) {
      assertThat(carInfoList.get(i).getNameOfCar()).isEqualTo(CAR_NAMES.get(i));
    }
  }

  @Test
  void findWinners_성공() {
    Cars cars = new Cars(CAR_NAMES);
    List<String> winners = cars.findWinners();
    assertThat(winners.containsAll(CAR_NAMES)).isTrue();
  }
}
