package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.strategy.MoveStrategy;

public class CarsTest {

	MoveStrategy moveStrategyMovable = () -> true;
	MoveStrategy moveStrategyNotMovable = () -> false;

	List<Car> newCarList;

	@BeforeEach
	void setUp() {
		this.newCarList = createCarList(5);
	}

	private List<Car> createCarList(int size) {
		List<Car> carList = new ArrayList<>();
		for (int i = 0; i < size; ++i) {
			carList.add(new Car());
		}
		return carList;
	}

	@Test
	@DisplayName("n대의 자동차는 전진할 수 있다")
	void n_cars_can_move() {
		Cars cars = new Cars(newCarList);
		cars.move(moveStrategyMovable);

		assertThat(newCarList).allSatisfy(
			car -> assertThat(car).isGreaterThan(new Car()));
	}

	@Test
	@DisplayName("n대의 자동차는 정지할 수 있다")
	void n_cars_can_stay() {
		Cars cars = new Cars(newCarList);
		cars.move(moveStrategyNotMovable);

		assertThat(newCarList).allSatisfy(
			car -> assertThat(car).isEqualByComparingTo(new Car()));
	}

	@Test
	@DisplayName("n번 움직일 수 있다")
	void cars_can_move_n_times() {
		List<Car> carListMovedOne = createCarList(5);
		Cars carsMovedOne = new Cars(carListMovedOne);
		carsMovedOne.move(moveStrategyMovable, 1);

		List<Car> carListMovedTwo = createCarList(5);
		Cars carsMovedTwo = new Cars(carListMovedTwo);
		carsMovedTwo.move(moveStrategyMovable, 2);

		assertThatListGreaterThanOther(carListMovedOne, newCarList);
		assertThatListGreaterThanOther(carListMovedTwo, carListMovedOne);
	}

	private void assertThatListGreaterThanOther(List<Car> list, List<Car> others) {
		assertThat(list).allSatisfy(
			carFromList -> assertThatCarGreaterThanOthers(carFromList, others));
	}

	private void assertThatCarGreaterThanOthers(Car car, List<Car> others) {
		assertThat(others).allSatisfy(
			carFromOthers -> assertThat(car).isGreaterThan(carFromOthers));
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

	private List<Integer> getPositions(List<Car> carList) {
		List<Integer> positions = new ArrayList<>();
		for (Car car : carList) {
			positions.add(car.getPosition());
		}
		return positions;
	}
}
