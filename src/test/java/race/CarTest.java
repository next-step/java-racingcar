package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

	@DisplayName("자동차를 이동시키고 이동한 거리를 반환한다.")
	@Test
	void 자동차의_거리를_이동시키는_TEST() {
		MovePolicy movePolicy = new SimpleMovePolicy();
		Car car = Car.of(movePolicy);
		for (int i = 0; i < 10; i++) {
			assertThat(car.move()).isEqualTo(i + 1);
		}
	}

	@DisplayName("자동차 여러대를 생성하고 이동한 거리를 반환")
	@Test
	void 자동차_여러대_거리를_이동시키는_TEST() {
		MovePolicy movePolicy = new SimpleMovePolicy();
		List<Car> cars = IntStream.rangeClosed(0, 10).mapToObj(i -> Car.of(movePolicy)).collect(Collectors.toList());
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < cars.size(); i++) {
				assertThat(cars.get(i).move()).isEqualTo(j + 1);
			}
		}
	}

	@DisplayName("자동차에 move를 실행할때 1씩 이동하는 전략을 주입한다")
	@Test
	void 자동차_이동_전략_TEST() {
		MovePolicy movePolicy = new SimpleMovePolicy();
		List<Car> cars = IntStream.rangeClosed(0, 10).mapToObj(i -> Car.of(movePolicy)).collect(Collectors.toList());
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < cars.size(); i++) {
				assertThat(cars.get(i).move()).isEqualTo(j + 1);
			}
		}
	}
}
