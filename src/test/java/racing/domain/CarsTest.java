package racing.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	private Cars cars;

	@BeforeEach
	void setup() {
		String carsName = "car1,car2,car3";
		cars = new Cars(carsName);
	}

	@Test
	@DisplayName("자동차의 이름의 콤마 수따라 생성된다.")
	public void createCars() {
		assertThat(cars.getInformation().size()).isEqualTo(3);
		assertThat(cars.getInformation()).extracting("name.name").containsExactly("car1", "car2", "car3");
	}

	@Test
	@DisplayName("경주완료 후 최고 점수를 반환한다.")
	public void searchMaxPosition() {
		Car car1 = new Car("car1");
		Car car2 = new Car("car2");
		Car car3 = new Car("car3");

		Cars cars = getCars(car1,car2,car3);

		int maxPosition = cars.maxPosition();

		assertThat(maxPosition).isEqualTo(2);
		assertThat(maxPosition).isEqualTo(car1.printPosition());
	}

	@Test
	@DisplayName("경주완료 후 최고점수에 따라 우승자를 반환한다.")
	public void searchWinner() {
		Car car1 = new Car("car1");
		Car car2 = new Car("car2");
		Car car3 = new Car("car3");

		Cars cars = getCars(car1,car2,car3);

		List<Car> winners = cars.winnerCars();

		assertThat(winners).extracting("name.name").containsExactly("car1", "car3");

	}

	private Cars getCars(Car car1, Car car2, Car car3) {
		car1.move(new DummyTrueRandomMove());
		car1.move(new DummyTrueRandomMove());

		car2.move(new DummyFalseRandomMove());
		car2.move(new DummyTrueRandomMove());

		car3.move(new DummyTrueRandomMove());
		car3.move(new DummyTrueRandomMove());

		return new Cars(car1, car2, car3);
	}

	private static class DummyFalseRandomMove extends RandomMoving{
		@Override
		public boolean movable(int randomValue) {
			return false;
		}
	}

	private static class DummyTrueRandomMove extends RandomMoving{
		@Override
		public boolean movable(int randomValue) {
			return true;
		}
	}

}