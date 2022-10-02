package racingcar.step3_4;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	private Cars cars;
	private Car firstCar;
	private Car secondCar;
	private Car thirdCar;

	@BeforeEach
	void setUp() {
		Names names = Names.of(new String[]{"pobi", "crong", "honux"});
		cars = Cars.createCars(names);
		firstCar = cars.getCars().get(0);
		secondCar = cars.getCars().get(1);
		thirdCar = cars.getCars().get(2);
	}

	@DisplayName("입력받은 자동차 대수만큼 자동차 생성")
	@Test
	void createCarsTest() {
		assertAll(
			() -> assertThat(cars.getCarsCount()).isEqualTo(3),
			() -> assertThat(firstCar.getPosition()).isZero(),
			() -> assertThat(secondCar.getPosition()).isZero(),
			() -> assertThat(thirdCar.getPosition()).isZero()
		);
	}

	@DisplayName("자동차 생성 - 이름 확인")
	@Test
	void createCarsNameTest() {
		assertAll(
			() -> assertThat(firstCar).isEqualTo(new Car(new Name("pobi"))),
			() -> assertThat(secondCar).isEqualTo(new Car(new Name("crong"))),
			() -> assertThat(thirdCar).isEqualTo(new Car(new Name("honux")))
		);
	}

	@DisplayName("자동차들 전진")
	@Test
	void moveCars() {
		cars.move(() -> 5);

		assertAll(
			() -> assertThat(firstCar.getPosition()).isEqualTo(1),
			() -> assertThat(secondCar.getPosition()).isEqualTo(1),
			() -> assertThat(thirdCar.getPosition()).isEqualTo(1)
		);
	}

	@DisplayName("각 자동차들 전진 혹은 멈춤")
	@Test
	void moveEachCar() {
		assertAll(
			() -> assertThat(firstCar.move(() -> 3)).isEqualTo(0),
			() -> assertThat(secondCar.move(() -> 4)).isEqualTo(1),
			() -> assertThat(thirdCar.move(() -> 9)).isEqualTo(1)
		);
	}

	@DisplayName("최종 우승 자동차 결정 - 우승자 한 명")
	@Test
	void determineWinnerTest() {
		firstCar.move(() -> 3);
		secondCar.move(() -> 2);
		thirdCar.move(() -> 9);

		List<Car> winners = cars.determineWinners();

		assertThat(winners).hasSize(1);
	}

	@DisplayName("최종 우승 자동차 결정 - 우승자 두 명이상")
	@Test
	void determineWinnersTest() {
		firstCar.move(() -> 3);
		secondCar.move(() -> 4);
		thirdCar.move(() -> 9);

		List<Car> winners = cars.determineWinners();

		assertThat(winners).hasSize(2);
	}
}
