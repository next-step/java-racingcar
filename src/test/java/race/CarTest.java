package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

	@DisplayName("자동차를 이동시키고 이동한 거리가 일치하는지 확인한다.")
	@Test
	void 자동차_거리_이동_TEST() {
		MovePolicy movePolicy = new SimpleMovePolicy();
		Car car = Car.of(movePolicy);
		IntStream.range(0, 10).forEach(i -> {
			car.move();
		});
		assertThat(car.nowDistance()).isEqualTo(10);
	}

	@DisplayName("자동차를 여러대 이동시키고 최종 거리가 일치하는지 확인한다.")
	@Test
	void 자동차_여러대_이동_TEST() {
		MovePolicy movePolicy = new SimpleMovePolicy();
		CarGroup carGroup = CarGroup.of(10, movePolicy);
		IntStream.range(0, 5).forEach(i -> {
			carGroup.moveAll();
		});
		assertThat(carGroup.ofCarIndex(1).nowDistance()).isEqualTo(5);
	}
}
