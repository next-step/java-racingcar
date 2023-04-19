package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.CarRacingGame;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingGameTest {

    @DisplayName("자동차의 출력 상태값 만들기(1회 전진마다 -추가")
    @ParameterizedTest
    @CsvSource(value = {"0:''", "1:'-'", "2:'--'", "3:'---'", "4:'----'", "5:'-----'"}, delimiter = ':')
    void makeCarMoveStateLine(int moveCount, String result) {
        //given
        ResultView resultView = new ResultView();

        //when
        String carMoveStateLine = resultView.makeCarMoveStateLine(moveCount);

        //then
        assertThat(carMoveStateLine).isEqualTo(result);
    }

    @DisplayName("자동차의 이동 횟수 리스트 만들기")
    @Test
    void makeMoveCounts() {
        //given
        String carNameInput = "pobi,crong,honux,choi";
        List<Integer> numbers = Arrays.asList(1, 2, 4, 5);

        //when
        List<Car> cars = new CarRacingGame(carNameInput).makeMoveCounts(numbers);
        List<Integer> moveCounts = new ArrayList<>();
        for (Car car : cars) {
            moveCounts.add(car.moveCount().value());
        }

        //then
        assertThat(moveCounts).containsExactly(0, 0, 1, 1);
    }

    @DisplayName("우승자 판별")
    @Test
    void getWinnersNames() {
        //given
        CarRacingGame carRacingGame = new CarRacingGame("pobi,crong,honux");

        //when
        carRacingGame.makeMoveCounts(Arrays.asList(1, 4, 5));
        List<Car> winningCars = carRacingGame.winningCars();

        //then
        assertThat(winningCars).containsExactly(new Car("crong", 1), new Car("honux", 1));
    }
}
