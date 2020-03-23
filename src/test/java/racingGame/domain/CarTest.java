package racingGame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

	private Car car;
	private Engine engine = () -> 5;

	@BeforeEach
	public void setCar() {
		this.car = new Car("teahyuk", engine);
	}

	@Test
	@DisplayName("최초 거리 측정")
	void getDistance() {
		assertThat(car.getDistance())
				.isEqualTo(0);
	}

	@Test
	@DisplayName("움직인 후에 거리 측정")
	void move() {
		car.move();
		assertThat(car.getDistance())
				.isEqualTo(engine.moveDistanceForOneTime());

		int tmpDistance = car.getDistance();

		car.move();
		assertThat(car.getDistance())
				.isEqualTo(tmpDistance+engine.moveDistanceForOneTime());
	}

	@Test
	void isSameDistance() {
		assertThat(car.isSameDistance(0))
				.isTrue();
	}
}