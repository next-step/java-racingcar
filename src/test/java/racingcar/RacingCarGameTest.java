package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarGameTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("입력한 차 대수만큼  경주에 참여하는 차 리스트 생성")
    public void createCarTest(int carCount) {
        RacingCarGame racingCarGame = new RacingCarGame(carCount, 0);
        List<Car> carList = racingCarGame.getCarList();

        assertThat(carList).hasSize(carCount);
    }

    @Test
    @DisplayName("자동차가 전진한만큼 차 위치 출력")
    void resultPathTest() {
        int moveCount = 3;
        Car car = new Car(new FixedGenerator(MovingCondtion.MOVABLE_MIN_VALUE));
        for (int i = 0; i < moveCount; i++) {
            car.tryMove();
        }

        assertThat(ResultView.getPathString(car.getPosition())).isEqualTo("---");
    }
}
