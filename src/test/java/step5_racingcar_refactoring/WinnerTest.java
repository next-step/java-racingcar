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
		List<Car> carList = new ArrayList<>();
		carList.add(new Car("car1", 0, bound -> 5));
		carList.add(new Car("car2", 1, bound -> 5));
		carList.add(new Car("car3", 0, bound -> 5));

		Cars cars = new Cars(carList);

		Set<Car> winners = winner.findWinners(cars);

		String expectedWinners1 = "car2";
		assertEquals(expectedWinners1, resultView.printWinnerNames(winner));
	}

	@DisplayName("2명의 우승자")
	@Test
	void winnerTest_2() {
		List<Car> carList = new ArrayList<>();
		carList.add(new Car("car1", 0, bound -> 5));
		carList.add(new Car("car2", 1, bound -> 5));
		carList.add(new Car("car3", 1, bound -> 5));

		Cars cars = new Cars(carList);

		Set<Car> winners = winner.findWinners(cars);
		String expectedWinners2 = "car2, car3";
		assertEquals(expectedWinners2, resultView.printWinnerNames(winner));
	}

	@DisplayName("5명의 우승자")
	@Test
	void winnerTest_5() {
		List<Car> carList = new ArrayList<>();
		carList.add(new Car("car1", 4, bound -> 5));
		carList.add(new Car("car2", 3, bound -> 5));
		carList.add(new Car("car3", 4, bound -> 5));
		carList.add(new Car("car4", 3, bound -> 5));
		carList.add(new Car("car5", 4, bound -> 5));
		carList.add(new Car("car6", 4, bound -> 5));
		carList.add(new Car("car7", 4, bound -> 5));

		Cars cars = new Cars(carList);

		Set<Car> winners = winner.findWinners(cars);
		String expectedWinners2 = "car1, car3, car5, car6, car7";
		assertEquals(expectedWinners2, resultView.printWinnerNames(winner));
	}

}
