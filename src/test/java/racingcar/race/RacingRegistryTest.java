package racingcar.race;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.DiceRacingRule;
import racingcar.RacingDice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class RacingRegistryTest {

    final String DEFAULT_CAR_NAME = "벤츠,제네시스,아우디";
    final List<String> DEFAULT_CAR_NAME_LIST = List.of("벤츠", "제네시스", "아우디");
    final int DEFAULT_RACING_TIME = 10;

    @DisplayName("입력한 Car Name 이 null 일 때 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    public void createCarListNullEmptyTest(String source) {
        assertThatThrownBy(() -> RacingRegistry.getCarList(source))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 Car Name 이 Split 된 Size 만큼 Car 가 생성된다.")
    @Test
    public void createCarListTest() {
        int defaultCarNameSize = 3;

        final List<Car> carList = RacingRegistry.getCarList(DEFAULT_CAR_NAME);
        List<String> carNames = new ArrayList<>();
        carList.forEach(car -> carNames.add(car.getName()));

        assertThat(carList.size()).isEqualTo(defaultCarNameSize);
        assertThat(carNames).isEqualTo(DEFAULT_CAR_NAME_LIST);

    }
}