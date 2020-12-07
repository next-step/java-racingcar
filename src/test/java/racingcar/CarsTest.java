package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

	NumberGenerator fixedNumber4Generator;
	NumberGenerator fixedNumber3Generator;

	@BeforeEach
	void setUp() {
		fixedNumber4Generator = new NumberGenerator() {
			@Override
			public int createNumber() {
				return 4;
			}
		};

		fixedNumber3Generator = new NumberGenerator() {
			@Override
			public int createNumber() {
				return 3;
			}
		};
	}

	@ParameterizedTest
	@ValueSource(strings = {"one", "one,two,three", "one,two,three,four,five"})
	@DisplayName("입력된 이름의 수만큼 Car 리스트가 생성되어야 한다")
	void carsCreateByNameTest(String names) {
		List<String> carNames = Arrays.asList(names.split(","));
		Cars cars = new Cars(carNames, new RandomNumberGenerator());
		assertThat(cars.sizeOfCars()).isEqualTo(carNames.size());
	}

	@Test
	@DisplayName("자동차 이름이 5자를 초과하면 IllegalArgumentException 을 throw 해야한다")
	void throwIllegalArgumentExceptionTest() {
		String names = "one,two,eleven";
		List<String> carNames = Arrays.asList(names.split(","));
		assertThatThrownBy(() -> new Cars(carNames, new RandomNumberGenerator()))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 3, 5, 100})
	@DisplayName("4이상의 숫자가 나오면 반복 횟수만큼 Car 리스트의 moveCount가 모두 누적되어 증가해야한다")
	void carsMoveTest(int moveCount) {
		Cars cars = new Cars(Arrays.asList("one","two","three","four","five"), fixedNumber4Generator);
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
		List<String> abc = Arrays.asList("a", "b");
		Cars cars = new Cars(Arrays.asList("one","two","three","four","five"), fixedNumber3Generator);
		List<Integer> expectedResult = Arrays.asList(0, 0, 0, 0, 0);
		for (int i = 0; i < moveCount; i++) {
			cars.move();
		}
		assertThat(cars.getMoveResult()).isEqualTo(expectedResult);
	}
}
