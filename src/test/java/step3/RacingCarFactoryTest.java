package step3;

import static org.assertj.core.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarFactoryTest {
  @ParameterizedTest
  @ValueSource(ints = {1})
  void createRacingCarList(int numberOfCars) {
    List<Car> racingCarList = RacingCarFactory.createRacingCarList(numberOfCars);
    
    for (Car car : racingCarList) {
      assertThat(car).isEqualToComparingFieldByField(new RacingCar());
    }
    
  }
}
