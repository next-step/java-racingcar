package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.RacingCarGameService;
import racingcar.model.Car;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private static final String TEST_CAR_NAMES = "pobi,crong,honux";

    @Test
    @DisplayName("자동차 이름 초기화 확인 테스트")
    public void testSaveCarName() {
        String[] names = TEST_CAR_NAMES.split(",");
        List<Car> cars = RacingCarGameService.getInstance().initCars(TEST_CAR_NAMES);
        IntStream.range(0, names.length).forEach(i -> assertThat(cars.get(i).getName()).isEqualTo(names[i]));
    }

    @Test
    @DisplayName("게임 로직 정상실행 통합 테스트")
    public void testGameLogic() {
        RacingCarGameService.getInstance().gameLogic(TEST_CAR_NAMES, 5);
    }

}
