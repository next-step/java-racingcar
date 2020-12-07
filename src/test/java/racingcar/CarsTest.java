package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {
	NumberGenerator fixedNumber4Generator = new NumberGenerator() {
		@Override
		public int createNumber() {
			return 4;
		}
	};
	NumberGenerator fixedNumber3Generator = new NumberGenerator() {
		@Override
		public int createNumber() {
			return 3;
		}
	};

	@ParameterizedTest
	@ValueSource(ints = {1, 3, 5, 100})
	@DisplayName("입력된 숫자만큼 Car 리스트 생성되어야 한다")
	void carsCreateTest(int carCount) {
		Cars cars = new Cars(carCount, new RandomNumberGenerator());
		assertThat(cars.sizeOfCars()).isEqualTo(carCount);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 3, 5, 100})
	@DisplayName("4이상의 숫자가 나오면 반복 횟수만큼 Car 리스트의 moveCount가 모두 누적되어 증가해야한다")
	void carsMoveTest(int moveCount) {
		Cars cars = new Cars(5, fixedNumber4Generator);
		List<Integer> expectedResult = Arrays.asList(moveCount, moveCount, moveCount, moveCount, moveCount);
		for (int i = 0; i < moveCount; i++) {
			cars.move();
		}
		assertThat(cars.getMoveResult()).isEqualTo(expectedResult);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 3, 5, 100})
	@DisplayName("4미만의 숫자는 몇 번을 반복해도 Car 리스트의 moveCount가 0으로 유지돼야한다")
	void carsStopTest(int moveCount) {
		Cars cars = new Cars(5, fixedNumber3Generator);
		List<Integer> expectedResult = Arrays.asList(0, 0, 0, 0, 0);
		for (int i = 0; i < moveCount; i++) {
			cars.move();
		}
		assertThat(cars.getMoveResult()).isEqualTo(expectedResult);
	}
}
