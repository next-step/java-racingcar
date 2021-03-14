package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("0~9까지 랜덤 출력")
    @Test
    void random_test() {
        System.out.println(new RacingCar(new Car()).random());
    }


    @DisplayName("주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:1 ", "3:5"}, delimiter = ':')
        void cars_can_moves_given_number_test(int cars, int count) {

        RacingGame racingGame = new RacingGame(cars, count);
        List<RacingCar> list = racingGame.settingRacingCars(cars);
        racingGame.gameStart(list, count);
        assertThat(list.size()).isEqualTo(cars);
        assertThat(count).isEqualTo(racingGame.getRound());

    }
    
}
