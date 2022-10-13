package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.strategy.MoveStrategy;

public class CarsTest {

	private final MoveStrategy moveStrategyMovable = () -> true;
	private final MoveStrategy moveStrategyNotMovable = () -> false;

	private List<Car> newCarList;

	@BeforeEach
	void setUp() {
		this.newCarList = createCarList(5);
	}

	@Test
	@DisplayName("n대의 자동차는 전진할 수 있다")
	void n_cars_can_move() {
		Cars cars = new Cars(newCarList);
		cars.move(moveStrategyMovable);

		assertThat(newCarList).allSatisfy(
			car -> assertThat(car.hasPositionSameAs(0)).isTrue());
	}

	@Test
	@DisplayName("n대의 자동차는 정지할 수 있다")
	void n_cars_can_stay() {
		Cars cars = new Cars(newCarList);
		cars.move(moveStrategyNotMovable);

		assertThat(newCarList).allSatisfy(
			car -> assertThat(car.getPosition()).isZero());
	}

	@Test
	@DisplayName("n대 자동차의 위치를 반환할 수 있다")
	void positions_can_be_returned() {
		Cars cars = new Cars(newCarList);
		cars.move(moveStrategyNotMovable);

		List<Integer> positions = getPositions(newCarList);
		List<Integer> retrievedPositions = cars.getPositions();

		assertThat(retrievedPositions).containsAll(positions);
	}

	@Test
	@DisplayName("이름들로 자동차를 생성한다")
	void construct_cars_with_names() {
		List<String> names = List.of("이름1", "이름2", "이름3");
		Cars cars = Cars.ofNames(names);
		List<String> retrievedNames = cars.getNames();

		assertThat(retrievedNames).containsAll(names);
	}

	@Test
	@DisplayName("우승자들 이름을 반환한다")
	void return_winner_names() {
		List<Car> expectedWinners = newCarList.subList(1, 3);
		Cars winningCars = new Cars(expectedWinners);
		List<String> expectedNames = winningCars.getNames();
		winningCars.move(moveStrategyMovable);

		Cars cars = new Cars(newCarList);
		List<String> winnerNames = cars.findWinnerNames();

		assertThat(winnerNames).containsAll(expectedNames);
	}

	private List<Integer> getPositions(List<Car> carList) {
		List<Integer> positions = new ArrayList<>();
		for (Car car : carList) {
			positions.add(car.getPosition());
		}
		return positions;
	}

	private List<Car> createCarList(int size) {
		List<Car> carList = new ArrayList<>();
		for (int i = 0; i < size; ++i) {
			carList.add(new Car());
		}
		return carList;
	}
}
