package new_racingcar.domain;

import new_racingcar.strategy.MoveOneStrategy;
import new_racingcar.strategy.MoveZeroStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Cars 테스트")
class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    @DisplayName("자동차 생성 개수 확인")
    public void createCarsSizeTest(String inputName) throws Exception {
        //given
        List<String> names = Arrays.asList(inputName.split(","));

        //when
        Cars car = new Cars(names, new MoveOneStrategy());
        int carSize = car.getUnmodifiableCars().size();

        //then
        assertThat(carSize).isEqualTo(inputName.split(",").length);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    @DisplayName("전략에 따른 자동차 움직임 확인 - MOVE ZERO")
    public void moveZeroStrategyRunTest(String inputName) throws Exception {
        //given
        List<String> names = Arrays.asList(inputName.split(","));

        //when
        Cars car = new Cars(names, new MoveOneStrategy());
        Round round = new Round(car.run(new MoveZeroStrategy()));

        //then
        assertThat(round.getMaxDistance()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux,1234,123,432"})
    @DisplayName("전략에 따른 자동차 움직임 확인 - MOVE ONE")
    public void moveOneStrategyRunTest(String inputName) throws Exception {
        //given
        List<String> names = Arrays.asList(inputName.split(","));

        //when
        Cars car = new Cars(names, new MoveOneStrategy());
        Round round = new Round(car.run());

        //then
        assertThat(round.getMaxDistance()).isEqualTo(1);
    }
}