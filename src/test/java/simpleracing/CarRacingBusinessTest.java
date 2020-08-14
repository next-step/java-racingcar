package simpleracing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import simpleracing.domain.rule.CarRacingMoving;
import simpleracing.domain.tools.Car;
import simpleracing.domain.tools.Record;

@DisplayName("레이싱 게임 비즈니스 로직 테스트")
public class CarRacingBusinessTest {

	@DisplayName("랜덤 값 대로 전진에 대한 값이 정확히 나오는지 테스트1")
	@ParameterizedTest
	@MethodSource("carParameterProvider")
	public void directionTest1(Car car) {
		Record record = car.play(new CarRacingMoving());

		assertThat(record.getLocation()).isEqualTo(record.drawLocation().length());
	}

	private static Stream<Arguments> carParameterProvider() {
		return Stream.of(
				Arguments.arguments(new Car("1")),
				Arguments.arguments(new Car("2")),
				Arguments.arguments(new Car("3")),
				Arguments.arguments(new Car("4")),
				Arguments.arguments(new Car("5")),
				Arguments.arguments(new Car("6")),
				Arguments.arguments(new Car("7")),
				Arguments.arguments(new Car("8")),
				Arguments.arguments(new Car("9")),
				Arguments.arguments(new Car("10")));
	}
}
