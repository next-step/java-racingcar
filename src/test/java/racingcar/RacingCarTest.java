package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.Car;
import racingcar.module.RacingGame;
import racingcar.module.GameManager;
import racingcar.util.RandomUtil;
import racingcar.util.ValidationUtil;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private ValidationUtil ValidationUtil;

    @DisplayName("입력 값이 숫자가 아닌 값 일때 false 반환")
    @ParameterizedTest
    @CsvSource(value = {"1:true" , "d:false" , "1:true"}, delimiter = ':')
    void inputNumber(String input, boolean result) {
        //GIVE

        //WHEN

        //THEN
        assertThat(ValidationUtil.isNumber(input)).isEqualTo(result);
    }

    @DisplayName("게임 횟수 만큼 Car 객체 생성 크기 비교")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    void carInstanceLength(int input, int result) {
        //GIVE
        GameManager gameManager = new GameManager();
        //WHEN

        //THEN
        assertThat(gameManager.initCarGame(input)).hasSize(result);
    }

    @DisplayName("random 값 0에서 부터 9까지 나오는지 확인")
    @Test
    void random(int input, int result) {
        //GIVE

        //WHEN
        //THEN
        assertThat(RandomUtil.randomNum()).isBetween(0, 9);
    }
    @DisplayName("게임 횟수 만큼 게임이 진행되는지 비교")
    @Test
    void startGame() {
        //GIVE
        List<Car> carList = Arrays.asList(new Car[]{new Car(1), new Car(2)});
        RacingGame game = new RacingGame(carList);
        int total;
        //WHEN
        total = game.startGame(2);
        //THEN
        assertThat(total).isEqualTo(0);
    }

    @DisplayName("move메소드 실행 시 Car Position 값이 증가하는지 비교")
    @Test
    void moveCar() {
        //GIVE
        Car car = new Car(1);
        //WHEN
        car.move();
        //THEN
        assertThat(car.getPosition()).isEqualTo(1);
    }


    @BeforeEach
    void createInstance() {
        ValidationUtil = new ValidationUtil();
    }

}
