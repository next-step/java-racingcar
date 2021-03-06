package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.racingcar.entity.Car;

public class RacingCarTest {

	@ParameterizedTest
	@DisplayName("input 값 전진")
	@CsvSource(value = {"1:6", "2:7", "3:8"}, delimiter = ':')
	void 전진(int input, int expected) {
		for (int i = 0; i < 5; i++) {
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
		Car car = new Car("전연빈");
		car.move(param);

		assertEquals(car.getStep() == 1, param >= 4);
	}

	@Test
	void 차_진행_문자열() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		// given
		Car car = new Car("전연빈");

		// when
		car.move(5);
		car.move(5);
		car.move(5);

		Method method = car.getClass().getDeclaredMethod("getStepString");
		method.setAccessible(true);

		// then
		assertThat(method.invoke(car))
			.isEqualTo("---");
	}

	@ParameterizedTest
	@CsvSource(value = {"crong,crong : ", "honux,honux : ", "pobi,pobi : "})
	void 차_이름별_테스트(String input, String expected) {

		Car car = new Car(input);

		assertThat(car.getStepStringWithName().trim())
			.isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("차 이름 5자 이상")
	@ValueSource(strings = {"abcdeff", "abcdeffff", "feffffeff", "안녕하십니까"})
	void 차_이름_다섯자_이상(String input) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new Car(input))
			.withMessageMatching("정상적인 사용자 값이 아닙니다.");
	}

}
