package step5_racingcar_refactoring;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step5_racingcar_refactoring.domain.Cars;
import step5_racingcar_refactoring.service.GameProcess;

public class GameProcessTest {
	private static final String[] carNames = "f1,suv,sport,super,jeep".split(",");

	@DisplayName("try 횟수와 플레이 횟수 일치 확인")
	@Test
	void testPlay() {
		int tryCount = 6;
		Cars cars = new Cars(carNames);
		GameProcess gameProcess = new GameProcess();
		List<Cars> results = gameProcess.play(tryCount, cars);
		assertEquals(tryCount, results.size());
	}
}
