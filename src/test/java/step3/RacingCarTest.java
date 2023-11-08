package step3;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.Car;
import step3.domain.RacingGame;
import step3.domain.Round;
import step3.utils.RandomUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("생성된 자동차의 기본 포지션은 0 이어야 한다.")
    void initCarPositionIs1() {
        Car car = new Car();
        assertThat(car.getCarPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("랜덤값은 0 ~ 9 사이어야 한다.")
    void randomNumberBetween0to9() {
        for(int i = 0; i < 100; i++) {
            assertThat(RandomUtils.generateRandomNumber()).isBetween(0, 9);
        }
    }

    @ParameterizedTest
    @DisplayName("4 이상인 경우 자동차는 전진한다.")
    @CsvSource(value = {"1,0", "4, 1", "9, 1"}, delimiter = ',')
    void racingCarMoveForward(int value, int expected) {
        Car car = new Car();
        car.tryMove(value);
        assertThat(car.getCarPosition()).isEqualTo(expected);
    }

    @Test
    @DisplayName("라운드 별로 자동차의 상태가 개별로 저장 되어야 한다.")
    void eachRoundHaveOwnCars() {
        int tryCountNumber = 3;
        int racingCarCountNumber = 3;
        RacingGame racingGame = new RacingGame(racingCarCountNumber, tryCountNumber);
        racingGame.play();
        List<Round> rounds = racingGame.getRounds();
        Set<String> address = new HashSet<>();
        rounds.stream().forEach(round ->
                round.getRoundCarStatus().getCars().forEach(car -> address.add(car.toString())));

        assertThat(address).hasSize(tryCountNumber * racingCarCountNumber);
    }

}
