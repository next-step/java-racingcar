package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.movestrategy.MoveStrategy;

public class CarsTest {

	MoveStrategy movableStrategy = () -> true;
	MoveStrategy unmovableStrategy = () -> false;

	@Test
	@DisplayName("n대의 자동차는 전진할 수 있다")
	void n_cars_can_move() {
		List<Car> carList = createCarList();
		Cars cars = new Cars(carList);
		cars.move(movableStrategy);

		assertThat(carList).allSatisfy(
			car -> assertThat(car).isGreaterThan(new Car()));
	}

	@Test
	@DisplayName("n대의 자동차는 정지할 수 있다")
	void n_cars_can_stay() {
		List<Car> carList = createCarList();
		Cars cars = new Cars(carList);
		cars.move(unmovableStrategy);

		assertThat(carList).allSatisfy(
			car -> assertThat(car).isEqualByComparingTo(new Car()));
	}

	@Test
	@DisplayName("n번 움직일 수 있다")
	void cars_can_move_n_times() {
		List<Car> carListMovedOne = createCarList();
		Cars carsMovedOne = new Cars(carListMovedOne);
		carsMovedOne.move(movableStrategy, 1);

		List<Car> carListMovedTwo = createCarList();
		Cars carsMovedTwo = new Cars(carListMovedTwo);
		carsMovedTwo.move(movableStrategy, 2);

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
	@DisplayName("n대 자동차의 위치를 순서대로 반환할 수 있다")
	void positions_can_be_returned_ordered() {
		List<Car> carList = createCarList();
		Cars cars = new Cars(carList);
		cars.move(movableStrategy);

		List<Integer> positions = getPositions(carList);
		List<Integer> retrievedPositions = getPositionsFromDTO(cars.getCarDTOs());

		assertThat(retrievedPositions).containsExactlyElementsOf(positions);
	}

	private List<Integer> getPositions(List<Car> carList) {
		List<Integer> positions = new ArrayList<>();
		for (Car car : carList) {
			positions.add(car.getPosition());
		}
		return positions;
	}

	private List<Integer> getPositionsFromDTO(List<CarDTO> carDTOs) {
		List<Integer> retrievedPositions = new ArrayList<>();
		for (CarDTO carDTO : carDTOs) {
			retrievedPositions.add(carDTO.getPosition());
		}
		return retrievedPositions;
	}

	private List<Car> createCarList() {
		List<Car> carList = new ArrayList<>();
		for (int i = 0; i < 5; ++i) {
			carList.add(new Car());
		}
		return carList;
	}
}
