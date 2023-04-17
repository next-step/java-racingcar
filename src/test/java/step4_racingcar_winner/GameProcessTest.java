package step4_racingcar_winner;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4_racingcar_winner.domain.Cars;
import step4_racingcar_winner.dto.CarDTO;
import step4_racingcar_winner.service.GameProcess;

public class GameProcessTest {
	private static final String[] carNames = "f1,suv,sport,super,jeep".split(",");


	@DisplayName("테스트 횟수 일치 여부 확인")
	@Test
	void testPlay() {
		int tryCount = 6;
		Cars cars = new Cars(carNames);
		GameProcess gameProcess = new GameProcess();
		List<List<CarDTO>> results = gameProcess.play(tryCount, cars);
		assertEquals(tryCount, results.size());
	}
}
