package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.Car;
import step3.model.Race;
import step3.model.RaceBoard;
import step3.view.RaceResultView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class RacingCarTests {

    @ParameterizedTest
    @ValueSource(ints = {3})
    @DisplayName("랜덤으로 뽑혔던 숫자가 4보다 작을 경우 false를 반환한다.")
    void canRaceStart(int times) {
        assertThat(new Car().isMovable(times)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {5})
    @DisplayName("입력한 자동차 대수 크기에 맞게 레이스 보드 배열이 생성된다.")
    void generateBoard(int cars) {
        assertThat(new RaceBoard(cars).generate().size()).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {3})
    @DisplayName("입력한 자동차 대수가 3대라면 초기 레이스 보드는 3이다.")
    void generateBoardArrays(int cars) {
        assertThat(new RaceBoard(cars).generate().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("랜덤으로 생성하는 전진 횟수는 0에서 9 사이의 숫자이다.")
    void generateRandomValue() {
        assertThat(Race.getRandomValue())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(10);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:5"}, delimiter = ':')
    @DisplayName("4 이상의 랜덤숫자가 나왔다면 자동차를 1칸 전진시킨다.")
    void carMoves(int cars, int randomValue) {
        List<Car> carList = new RaceBoard(cars).generate();
        assertThat(new Car().isMovable(randomValue)).isTrue();

        carList.get(0).go();
        assertThat(carList.get(0).getCurrentStatus()).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:3"}, delimiter = ':')
    @DisplayName("4보다 작은 랜덤숫자가 나왔다면 자동차를 전진시키지 않는다.")
    void carDoNotMove(int cars, int randomValue) {
        List<Car> carList = new RaceBoard(cars).generate();
        assertThat(new Car().isMovable(randomValue)).isFalse();

        assertThat(carList.get(0).getCurrentStatus()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {3})
    @DisplayName("결과를 담은 배열 값이 출력되는지 검증한다.")
    void showResult(int cars) {
        List<Car> carList = new RaceBoard(cars).generate();

        RaceResultView raceResult = mock(RaceResultView.class);
        raceResult.show();
        verify(raceResult, times(1));
    }
}
