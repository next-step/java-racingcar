package step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

	private static final int ONE_STEP = 1;

	@ParameterizedTest
	@CsvSource({"0,false", "1,false", "2,false", "3,false", "4,true",
				"5,true",  "6,true",  "7,true",  "8,true",  "9,true"})
	@SuppressWarnings("NonAsciiCharacters")
	void 랜덤생성된_숫자에따라_자동차_전진_여부가_결정된다(int randomNumber, boolean carMoveResult) {
		// given
		Car car = new StubCar(randomNumber);

		// when
		car.moveIfLucky();

		// then
		assertThat(doesCarMoveOneStep(car)).isEqualTo(carMoveResult);
	}

	private boolean doesCarMoveOneStep(Car car) {
		return car.getStep() == ONE_STEP;
	}

	public static class StubCar extends Car {
		private int randomNumber;

		StubCar(int randomNumber) {
			this.randomNumber = randomNumber;
		}

		@Override
		protected int getRandomNumber() {
			return this.randomNumber;
		}
	}

}
