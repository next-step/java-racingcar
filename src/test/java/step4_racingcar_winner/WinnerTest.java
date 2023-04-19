package step4_racingcar_winner;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4_racingcar_winner.service.Winner;
import step4_racingcar_winner.view.ResultView;

public class WinnerTest {
	private Winner winner;
	private ResultView resultView;

	@BeforeEach
	void setUp() {
		winner = new Winner();
		resultView = new ResultView();
	}

	@DisplayName("1명의 우승자")
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
		assertEquals(expectedWinners1, resultView.printWinnerNames(winner));
	}

	@DisplayName("2명의 우승자")
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
		assertEquals(expectedWinners2, resultView.printWinnerNames(winner));
	}

	@DisplayName("5명의 우승자")
	@Test
	void winnerTest_5() {
		Map<String, Integer> testMap = new LinkedHashMap<>();
		testMap.put("car1", 9);
		testMap.put("car2", 9);
		testMap.put("car3", 9);
		testMap.put("car4", 9);
		testMap.put("car5", 9);

		winner.selectWinner(testMap);
		String expectedWinners2 = "car1, car2, car3, car4, car5";
		assertEquals(expectedWinners2, resultView.printWinnerNames(winner));
	}
}
