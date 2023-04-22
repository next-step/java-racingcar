package step5_racingcar_refactoring;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step5_racingcar_refactoring.domain.Car;
import step5_racingcar_refactoring.domain.Cars;
import step5_racingcar_refactoring.service.Winner;
import step5_racingcar_refactoring.view.ResultView;

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
		testMap.put("car1", 7);
		testMap.put("car2", 3);
		testMap.put("car3", 5);
		testMap.put("car4", 9);
		testMap.put("car5", 9);

		winner.selectWinner(testMap);
		String expectedWinners2 = "car4, car5";
		assertEquals(expectedWinners2, resultView.printWinnerNames(winner));
	}

	@DisplayName("5명의 우승자")
	@Test
	void winnerTest_5() {
		Map<String, Integer> testMap = new LinkedHashMap<>();
		testMap.put("car1", 7);
		testMap.put("car2", 7);
		testMap.put("car3", 7);
		testMap.put("car4", 7);
		testMap.put("car5", 7);

		winner.selectWinner(testMap);
		String expectedWinners2 = "car1, car2, car3, car4, car5";
		assertEquals(expectedWinners2, resultView.printWinnerNames(winner));
	}

}
