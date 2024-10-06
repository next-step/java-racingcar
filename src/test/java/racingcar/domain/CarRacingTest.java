package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingWrapResultsDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {
    @Test
    @DisplayName("생성되면 초기 상태 wrapResult만 가집니다.")
    void initializedWrapResultsSizeTest() {
        List<String> carNames = new ArrayList<>(Arrays.asList("Car1", "Car2", "Car3"));
        CarRacing racing = CarRacing.valueOf(carNames);
        assertThat(racing.getWrapResults().getWrapResults().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("생성되면 차 이름에 해당하는 차를 모두 가지고 있습니다.")
    public void racingCarsTest() {
        List<String> carNames = new ArrayList<>(Arrays.asList("Car1", "Car2", "Car3"));
        CarRacing racing = CarRacing.valueOf(carNames);
        List<RacingCar> racingCars = racing.getRacingCars();
        carNames.forEach(carName -> assertThat(racingCars)
                .filteredOn(racingCar -> racingCar.getName().equals(carName))
                .isNotEmpty());
    }

    @Test
    @DisplayName("wrap을 진행하면 wrapResult가 하나 추가됩니다.")
    public void proceedWrapTest() {
        List<String> carNames = new ArrayList<>(Arrays.asList("Car1", "Car2", "Car3"));
        CarRacing racing = CarRacing.valueOf(carNames);
        RacingWrapResultsDTO beforeWrapResults = racing.getWrapResults();
        racing.proceedWrap();
        RacingWrapResultsDTO afterWrapResults = racing.getWrapResults();
        assertThat(afterWrapResults.getWrapResults().size()).isEqualTo(beforeWrapResults.getWrapResults().size() + 1);
    }
}
