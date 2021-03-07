package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.racingcar.entity.RacingCar;
import study.racingcar.service.RacingCarGame;
import study.racingcar.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    private RacingCar racingCar;
    private RacingCarGame racingCarGame;
    private RandomGenerator randomGenerator;

    private RacingCar firstWinnerRacingCar;
    private RacingCar secondWinnerRacingCar;

    @BeforeEach
    void setup(){
        racingCar = new RacingCar(0, "Test");
        racingCarGame = new RacingCarGame();
        randomGenerator = new RandomGenerator();
        firstWinnerRacingCar = new RacingCar(5, "win1");
        secondWinnerRacingCar = new RacingCar(5, "win2");
    }

    @Test
    @DisplayName("랜덤 값 생성 범위가 0 ~ 9 맞는지 확인")
    void getRandomNumber(){
        assertThat(randomGenerator.getRandomNumber()).isLessThan(10);
        assertThat(randomGenerator.getRandomNumber()).isLessThanOrEqualTo(9);
        assertThat(randomGenerator.getRandomNumber()).isGreaterThan(-1);
        assertThat(randomGenerator.getRandomNumber()).isGreaterThanOrEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0" }, delimiter = ':')
    @DisplayName("값이 4 미만이면 정지 확인")
    void moveImPossible(Integer number, Integer expected){
        racingCar.oneStep(number);
        assertThat(racingCar.getPosition()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:1", "5:1", "6:1", "7:1", "8:1", "9:1" }, delimiter = ':')
    @DisplayName("값이 4 이상이면 1 전진 확인")
    void movePossible(Integer number, Integer expected){
        racingCar.oneStep(number);
        assertThat(racingCar.getPosition()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"test:true", "testC:true", "testCa:false", "testCar:false"}, delimiter = ':')
    @DisplayName("자동차 이름 5자 제한")
    void racingCarNameValidCheck(String carName, boolean expected){
        assertThat(racingCarGame.carNameValidCheck(carName)).isEqualTo(expected);
    }

    @Test
    @DisplayName("우승자 선정")
    void getWinner(){
        List<RacingCar> racingCarList = new ArrayList<>();
        racingCarList.add(racingCar);
        racingCarList.add(firstWinnerRacingCar);
        racingCarList.add(secondWinnerRacingCar);

        assertThat(racingCarGame.getWinnerNames(racingCarList)).contains("win1", "win2");
        assertThat(String.join(", ", racingCarGame.getWinnerNames(racingCarList))).isEqualTo("win1, win2");
    }

}
