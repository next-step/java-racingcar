package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarTest {

    @Test
    @DisplayName("자동차 전진 테스트")
    void moveTest() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
        car.move();
        car.move();
        assertThat(car.getPosition()).isEqualTo(3);
    }

    @DisplayName("게임 생성 : 자동차 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3", "5", "10"})
    void makeCarTest(int carSize) {
        Game game = new Game(carSize);
        assertThat(game.getCar().size()).isEqualTo(carSize);
    }

    @DisplayName("전진 또는 멈춤 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    void moveOrStopTest(int randomNumber, int expectedPosition) {
        Car car = new Car();
        car.moveOrStop(randomNumber);
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    @DisplayName("실행 횟수 테스트")
    void runTest() {
        Game game = new Game(1);
        game.run(5);
        assertThat(game.getExecuteCount()).isEqualTo(5);
        game.run(10);
        assertThat(game.getExecuteCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("실행 결과 테스트")
    void runExecuteTest() {
        Game game = new Game(3);
        game.run(5);
        assertThat(game.getCar()).allSatisfy(car -> assertThat(car.getPosition()).isBetween(0, 6));
    }

    @Test
    @DisplayName("우승자 테스트")
    void getWinnersTest() {
        // 우승자 1명
        String carName[] = {"Car A", "Car B", "Car C"};
        Game game = new Game(carName);
        List<Car> car = game.getCar();
        car.get(0).move();
        car.get(0).move();
        car.get(0).move();
        car.get(1).move();
        car.get(1).move();
        car.get(2).move();
        GameResult gameResult = new GameResult();
        gameResult.addResult(car);
        assertThat(gameResult.getWinners()).contains("Car A");

        // 우승자 2명
        Game game2 = new Game(carName);
        List<Car> car2 = game2.getCar();
        car2.get(0).move();
        car2.get(0).move();
        car2.get(1).move();
        car2.get(1).move();
        car2.get(2).move();
        gameResult = new GameResult();
        gameResult.addResult(car2);
        assertThat(gameResult.getWinners()).containsExactlyInAnyOrder("Car A", "Car B");
    }
}
