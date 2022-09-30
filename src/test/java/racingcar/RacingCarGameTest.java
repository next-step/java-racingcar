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

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("자동차가 전진한만큼 차 위치 이동")
    void moveTest(int moveCount) {
        Car car = new Car();
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }

        assertThat(car.getPosition()).isEqualTo(moveCount);
    }


    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1"}, delimiter = ':')
    @DisplayName("차가 전진하는 조건은 값이 4이상일 경우")
    void moveConditionsTest(int value, int expected) {
        Car car = new Car();
        car.tryMove(value);

        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "abc"})
    @DisplayName("양수가 아닌 값 입력시 예외처리")
    void inputExceptionTest(String input) {
        assertThatThrownBy(() -> {
            InputView.getPositiveInteger(input);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("0 이상의 숫자만 입력해주세요");
    }

    @Test
    @DisplayName("자동차가 전진한만큼 차 위치 출력")
    void resultPathTest() {
        int moveCount = 3;
        Car car = new Car();
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }

        assertThat(ResultView.getPathString(car.getPosition())).isEqualTo("---");
    }
}
