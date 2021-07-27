package racing.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

	@ParameterizedTest
	@DisplayName("경주시 랜덤변수 판단값에 따라 자동차를 움직인다.")
	@CsvSource(value = {"true,1,1,1", "false,0,0,0", "true,1,1,1"})
	public void carsRacing(boolean moveFlag, int raceResult1, int raceResult2, int raceResult3) {
		Cars racingResult1 = getMoveResult(cars, moveFlag);
		assertThat(racingResult1.getInformation()).extracting("position.position")
			.containsExactly(raceResult1, raceResult2, raceResult3);
	}

	private Cars getMoveResult(Cars cars, boolean moveFlag) {
		return cars.racing(new RandomMoving() {
			@Override
			public boolean movable() {
				return moveFlag;
			}
		});
	}

	@Test
	@DisplayName("경주완료 후 최고 점수를 반환한다.")
	public void searchMaxPosition() {
		Car car1 = new Car("car1");
		Car car2 = new Car("car2");
		Car car3 = new Car("car3");

		car1.move(true);
		car1.move(true);

		car2.move(false);
		car2.move(true);

		car3.move(true);
		car3.move(true);

		Cars cars = new Cars(car1, car2, car3);

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

		car1.move(true);
		car1.move(true);

		car2.move(false);
		car2.move(true);

		car3.move(true);
		car3.move(true);

		Cars cars = new Cars(car1, car2, car3);

		List<Car> winners = cars.winnerCars();

		assertThat(winners).extracting("name.name").containsExactly("car1", "car3");

	}

}