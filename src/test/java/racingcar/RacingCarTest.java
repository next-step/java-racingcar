package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.racingcar.entity.Car;

public class RacingCarTest {


	@ParameterizedTest
	@DisplayName("input 값 전진")
	@CsvSource(value = {"1:6", "2:7", "3:8"}, delimiter = ':')
	void 전진(int input, int expected){
		for (int i = 0; i < 5; i ++) {
			input++;
		}

		assertEquals(input, expected);
	}

	static List<Integer> getOneToTen() {
		return IntStream.range(0, 10)
			.boxed()
			.collect(Collectors.toList());
	}

	@ParameterizedTest
	@DisplayName("Car object move테스트")
	@MethodSource("getOneToTen")
	void 차_전진(Integer param) {
		Car car = new Car();
		car.move(param);

		assertEquals(car.getStep() == 1, param >= 4);
	}
}
