package racingcar;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import calculator.StringCalculator;
import racingcar.ui.RacingCarInput;
import utils.RandomUtils;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    void 초기_상태에서_display는_이름만_있다() {
        RacingCar car = new RacingCar(new RacingCarName("test"), new RandomRacingCarMoveStrategy());
        assertThat(car.display()).isEqualTo("test : ");
    }

    @ParameterizedTest
    @CsvSource(value = {"a,3,a : ---", "b,1,b : -", "c,2,c : --"})
    void 이동에_성공했다면_MOVE_SYMBOL이_추가된다(String carName, int moveCount, String expected) {
        RacingCar car = new RacingCar(new RacingCarName(carName), new AlwaysRacingCarMoveStrategy());

        for (int i = 0; i < moveCount; i++) {
            car.moveIfMovable();
        }

        assertThat(car.display()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"aa,3,aa : ", "bb,1,bb : ", "cc,2,cc : "}, ignoreLeadingAndTrailingWhitespace = false)
    void 이동에_실패했다면_MOVE_SYMBOL이_추가되지_않는다(String carName, int moveCount, String expected) {
        RacingCar car = new RacingCar(new RacingCarName(carName), new NeverRacingCarMoveStrategy());

        for (int i = 0; i < moveCount; i++) {
            car.moveIfMovable();
        }

        assertThat(car.display()).isEqualTo(expected);
    }

    @Test
    void RacingCar_정렬_테스트() {
        String[] carNames = StringCalculator.split("1,2,3,4");
        List<RacingCar> racingCars = RacingCar.createRacingCars(carNames);

        for (int i = 0; i < 100; i++) {
            int random = RandomUtils.random(0, 3);
            RacingCar racingCar = racingCars.get(random);
            racingCar.moveIfMovable();
        }

        List<RacingCar> rankedRacingCars = RacingCar.toSortedRacingCars(racingCars);

        assertThat(rankedRacingCars).isSorted();
    }
}
