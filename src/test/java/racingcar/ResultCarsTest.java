package racingcar;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.InputCars;
import racingcar.dto.ResultCars;
import racingcar.model.CarName;
import racingcar.model.Distance;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.CarNameTest.TEST_CAR_NAME;
import static racingcar.DistanceTest.TEST_DISTANCE;

@DisplayName("ResultCars DTO 테스트")
public class ResultCarsTest {

    @Test
    @DisplayName("입력받은 CarName 리스트가 null이면 NullPointerException이 발생한다.")
    void namesNullTest() {
        Assertions.assertThatThrownBy(() -> ResultCars.of(1, null, Lists.newArrayList(TEST_DISTANCE)))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("is null");
    }

    @Test
    @DisplayName("입력받은 distances 리스트가 null이면 NullPointerException이 발생한다.")
    void distancesNullTest() {
        Assertions.assertThatThrownBy(() -> ResultCars.of(1, Lists.newArrayList(TEST_CAR_NAME), null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("is null");
    }

    @Test
    @DisplayName("입력받은 리스트의 사이즈가 맞지 않으면 IllgalArgumentException 이 발생한다.")
    void resultCarsOfFailTest() {
        Assertions.assertThatThrownBy(() -> ResultCars.of(2, Lists.newArrayList(TEST_CAR_NAME), Lists.newArrayList(TEST_DISTANCE)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("count, names, distances 를 입력하면 ResultCars가 생성된다")
    void resultCarsOfTest() {
        // given
        int count = 2;
        List<CarName> names = InputCars.fromCarsInfo("test,test1").value().names();
        List<Distance> distances = Lists.newArrayList(new Distance(2), new Distance(3));

        // when
        ResultCars resultCars = ResultCars.of(count, names, distances);

        // then
        for (int i = 0; i < count; i++) {
            assertThat(resultCars.value().names().get(i)).isEqualTo(names.get(i));
            assertThat(resultCars.value().distances().get(i)).isEqualTo(distances.get(i));
        }
    }
}
