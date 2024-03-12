package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.RacingCarGameLogic;
import racingcar.RacingCarGameRule;
import racingcar.model.Car;


import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {
    private static final String TEST_CAR_NAMES = "pobi,crong,honux";
    @ParameterizedTest
    @DisplayName("4이상일 경우 전진하는 조건인지 테스트")
    @CsvSource({"3,false", "5,true", "8,true"})
    public void testIsMoving(int input, boolean output) {
        boolean isMoving = RacingCarGameRule.getInstance().isMovingForward(input);
        assertThat(isMoving).isEqualTo(output);
    }

    @Test
    @DisplayName("자동차 이름 초기화 확인 테스트")
    public void testSaveCarName() {
        String [] names = TEST_CAR_NAMES.split(",");
        List<Car> cars = RacingCarGameLogic.getInstance().initCars(TEST_CAR_NAMES);
        IntStream.range(0, names.length).forEach(i -> assertThat(cars.get(i).getName()).isEqualTo(names[i]));
    }

    @Test
    @DisplayName("게임 로직 정상실행 통합 테스트")
    public void testGameLogic() {
        RacingCarGameLogic.getInstance().gameLogic(TEST_CAR_NAMES,5);
    }

}
