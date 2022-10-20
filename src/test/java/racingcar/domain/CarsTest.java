package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.strategy.MoveStrategy;

public class CarsTest {

	private static final List<String> NAMES = List.of("acar", "bcar", "ccar", "dcar");

	private final MoveStrategy moveStrategyMovable = () -> true;
	private final MoveStrategy moveStrategyNotMovable = () -> false;

	private List<Car> carList;
	private Cars cars;

	@BeforeEach
	void setUp() {
		this.carList = NAMES.stream()
			.map(Car::new)
			.collect(Collectors.toList());
		this.cars = new Cars(carList);
	}

	@Test
	@DisplayName("n대의 자동차는 전진할 수 있다")
	void n_cars_can_move() {
		cars.move(moveStrategyMovable);

		assertThat(carList).allSatisfy(
			car -> assertThat(car.hasPositionSameAs(new Position(1))).isTrue());
	}

	@Test
	@DisplayName("n대의 자동차는 정지할 수 있다")
	void n_cars_can_stay() {
		cars.move(moveStrategyNotMovable);

		assertThat(carList).allSatisfy(
			car -> assertThat(car.getPosition()).isEqualTo(new Position(0)));
	}

	@Test
	@DisplayName("n대 자동차의 위치를 반환할 수 있다")
	void positions_can_be_returned() {
		cars.move(moveStrategyNotMovable);

		List<Integer> positions = getPositions(carList);
		List<Integer> retrievedPositions = cars.getPositions();

		assertThat(retrievedPositions).containsAll(positions);
	}

	@Test
	@DisplayName("이름들로 자동차를 생성한다")
	void construct_cars_with_names() {
		assertThat(cars.getNames()).containsAll(NAMES);
	}

	@Test
	@DisplayName("우승자들 이름을 반환한다")
	void return_winner_names() {
		List<Car> expectedWinners = carList.subList(1, 3);
		List<String> expectedWinnerNames = expectedWinners.stream()
			.map(Car::getName)
			.collect(Collectors.toList());
		for (Car car : expectedWinners) {
			car.move(moveStrategyMovable);
		}

		assertThat(cars.findWinnerNames()).containsAll(expectedWinnerNames);
	}

	private List<Integer> getPositions(List<Car> carList) {
		List<Integer> positions = new ArrayList<>();
		for (Car car : carList) {
			positions.add(car.getPosition().value());
		}
		return positions;
	}
}
