package step5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step5.model.Car;
import step5.model.CarFactory;
import step5.model.Cars;
import step5.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

  @ParameterizedTest
  @CsvSource(value = {"sepy,tango:1"}, delimiter = ':')
  @DisplayName("정상적인 분기가 처리되는지 확인")
  void runCycleTest(String carNames, int attempt) {
    Strategy strategy = () -> true;

    Cars cars = CarFactory.makeCars(carNames);

    int result = 0;
    for (int i = 0; i < attempt; i++) {
      if (cars.runCycle(strategy)) {
        result += 1;
      }
    }

    assertThat(result).isEqualTo(attempt);
  }

  @ParameterizedTest
  @CsvSource(value = {"povia,pob,poc,pod:5:7"}, delimiter = ':')
  @DisplayName("챔피언을 찾을 수 있는지 확인")
  void makeChampsTest(String carNames, int attempt, int maxLoc) {

    String[] list = carNames.split(",");
    List<Car> carList = new ArrayList<>();

    Car champ = new Car(list[0], maxLoc);
    Car secChamp = new Car(list[1], maxLoc);

    carList.add(champ);
    carList.add(secChamp);

    for (int i = 2; i < list.length; i++) {
      carList.add(new Car(list[i], 1));
    }

    Cars cars = new Cars(carList);
    Strategy strategy = () -> true;

    for (int i = 0; i < attempt; i++) {
      cars.runCycle(strategy);
    }

    List<Car> champs = cars.findWinners();

    Assertions.assertAll(
      () -> assertThat(champs.size()).isEqualTo(2),
      () -> assertThat(champs).contains(champ, secChamp)
    );
  }

}
