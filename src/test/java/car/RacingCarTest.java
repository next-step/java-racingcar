package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {
    private static final String TEST_CAR_NAMES = "pobi,crong,honux";

    @Test
    @DisplayName("자동차 이름 초기화 확인 테스트")
    public void testSaveCarName() {
        String[] names = TEST_CAR_NAMES.split(",");
        Cars cars = Cars.of(Arrays.asList(names));
        IntStream.range(0, names.length).forEach(i -> assertThat(cars.getCars().get(i).getName()).isEqualTo(names[i]));
    }

}
