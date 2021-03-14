package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.domain.GameResult;
import racingcar.domain.GameStatus;

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
	@DisplayName("단일 우승자 테스트")
	void getWinnersTest() {
		// 우승자 1명
		String carName[] = {"Car A", "Car B", "Car C"};
		Game game = new Game(carName);
		GameResult gameResult = new GameResult();
		GameStatus gameStatus = new GameStatus();

		List<Car> car = game.getCar();
		//1회
		car.get(0).move();
		car.get(1).move();
		gameStatus.add((Car)car.get(0).clone());
		gameStatus.add((Car)car.get(1).clone());
		gameStatus.add((Car)car.get(2).clone());
		gameResult.addResult(gameStatus);

		//2회
		car.get(0).move();
		gameStatus = new GameStatus();
		gameStatus.add((Car)car.get(0).clone());
		gameStatus.add((Car)car.get(1).clone());
		gameStatus.add((Car)car.get(2).clone());
		gameResult.addResult(gameStatus);

		assertThat(gameResult.getGameWinners()).contains("Car A");
	}

	@Test
	@DisplayName("다중 우승자 테스트")
	void getMultipleWinnersTest() {
		// 우승자 2명
		String carName[] = {"Car A", "Car B", "Car C"};
		Game game = new Game(carName);
		GameResult gameResult = new GameResult();
		GameStatus gameStatus = new GameStatus();

		List<Car> car = game.getCar();
		//1회
		car.get(0).move();
		car.get(1).move();
		car.get(2).move();
		gameStatus.add((Car)car.get(0).clone());
		gameStatus.add((Car)car.get(1).clone());
		gameStatus.add((Car)car.get(2).clone());
		gameResult.addResult(gameStatus);

		//2회
		car.get(0).move();
		car.get(1).move();
		gameStatus = new GameStatus();
		gameStatus.add((Car)car.get(0).clone());
		gameStatus.add((Car)car.get(1).clone());
		gameStatus.add((Car)car.get(2).clone());
		gameResult.addResult(gameStatus);

		assertThat(gameResult.getGameWinners()).containsExactlyInAnyOrder("Car A", "Car B");
	}
}
