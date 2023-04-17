package step4_racingcar_winner;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4_racingcar_winner.service.Winner;

public class WinnerTest {
	private Winner winner;

	@BeforeEach
	void setUp() {
		winner = new Winner();
	}

	@DisplayName("Winner 생성 및 기능 테스트 1")
	@Test
	void winnerTest_1() {
		Map<String, Integer> testMap = new LinkedHashMap<>();
		testMap.put("car1", 7);
		testMap.put("car2", 3);
		testMap.put("car3", 5);
		testMap.put("car4", 9);
		testMap.put("car5", 5);

		winner.selectWinner(testMap);
		String expectedWinners1 = "car4";
		assertEquals(expectedWinners1, winner.getWinner());
	}

	@DisplayName("Winner 생성 및 기능 테스트 2")
	@Test
	void winnerTest_2() {
		Map<String, Integer> testMap = new LinkedHashMap<>();
		testMap.put("car1", 6);
		testMap.put("car2", 4);
		testMap.put("car3", 5);
		testMap.put("car4", 8);
		testMap.put("car5", 8);

		winner.selectWinner(testMap);
		String expectedWinners2 = "car4, car5";
		assertEquals(expectedWinners2, winner.getWinner());
	}
}
