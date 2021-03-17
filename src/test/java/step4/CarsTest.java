package step4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.model.Car;
import step4.model.CarFactory;
import step4.model.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

  @ParameterizedTest
  @CsvSource(value = {"sleepy,tango:1"}, delimiter = ':')
  @DisplayName("정상적인 분기가 처리되는지 확인")
  void runCycleTest(String carNames, int attempt) {

    Cars cars = CarFactory.makeCars(carNames);

    int result = 0;
    for (int i = 0; i < attempt; i++) {
      if (cars.runCycle()) {
        result += 1;
      }
    }

    assertThat(result).isEqualTo(attempt);
  }

  @ParameterizedTest
  @CsvSource(value={"povia,pob,poc:5:7"}, delimiter = ':')
  @DisplayName("챔피언을 찾을 수 있는지 확인")
  void makeChampsTest(String carNames, int attempt, int maxLoc){
    String[] list = carNames.split(",");
    List<Car> carList = new ArrayList<>();

    carList.add(new Car(list[0],maxLoc));
    for(int i=1; i<list.length; i++){
      carList.add(new Car(list[i], 1));
    }
    Cars cars = new Cars(carList);

    for(int i=0; i<attempt; i++){
      cars.runCycle();
    }

    List<String> champs = cars.calcChampions();

    Assertions.assertAll(
            ()->assertThat(champs.size()).isEqualTo(1),
            ()->assertThat(champs).contains(list[0])
    );
  }

}
