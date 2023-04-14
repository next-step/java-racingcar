package step3_racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import step3_racingcar.domain.Car;
import step3_racingcar.domain.Cars;
import step3_racingcar.service.GameProcess;

public class GameProcessTest {
	@Test
	void testPlay() {
		int carCount = 4;
		int tryCount = 6;
		Cars cars = new Cars(carCount);
		GameProcess gameProcess = new GameProcess();
		List<List<Car>> results = gameProcess.play(tryCount, cars.getCars());
		assertEquals(tryCount, results.size());
	}
}
