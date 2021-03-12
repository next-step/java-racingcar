package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("0~9까지 랜덤 출력")
    @Test
    void random_test() {
        System.out.println(new RacingCar(new Car()).random());
    }


    @DisplayName("전진 테스트")
    @Test
    void isGo_test() {
        RacingCar racingCar = new RacingCar(new Car());
        String result = racingCar.isGo(5);
        assertThat(result).isEqualTo("-");

    }

    @DisplayName("멈춤 테스트")
    @Test
    void stop_test() {
        RacingCar racingCar = new RacingCar(new Car());
        String result = racingCar.isGo(3);
        assertThat(result).isEqualTo("");
    }


    @DisplayName("1대의 차가 1회 움직일 경우")
    @Test
    void one_car_moves_twice_test() {
        int cars = 1;
        int count = 1;

        RacingGameTest(cars, count);

    }

    @DisplayName("2대의 차가 1회 움직일 경우")
    @Test
    void two_car_moves_once_test() {
        int cars = 2;
        int count = 1;

        RacingGameTest(cars, count);
    }



    @DisplayName("주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.")
    @Test
        void cars_can_moves_given_number_test() {
        int cars = 3;
        int count = 5;

        RacingGameTest(cars, count);
    }

    @DisplayName("각 테스트 구간별로 중복되는 부분은 따로 뺌")
    private void RacingGameTest(int cars, int count) {
        RacingGame racingGame = new RacingGame(cars, count);
        List<RacingCar> list = racingGame.settingRacingCars(cars);
        racingGame.gameStart(list, count);
        assertThat(list.size()).isEqualTo(cars);
        assertThat(count).isEqualTo(racingGame.getRound());
    }

}
