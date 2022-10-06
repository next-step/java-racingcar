package carRacing.level3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import carRacing.level3.infra.error.NameLengthException;
import carRacing.level3.model.Car;
import carRacing.level3.model.strategy.RandomMovingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	public static final Integer DEFAULT_LOCATION = 0;

	@Test
	@DisplayName("이름은 5자를 초과하면 안된다")
	void 자동차_이름(){
		assertThatThrownBy(() -> {
			new Car("testCar1");
		}).isInstanceOf(NameLengthException.class);;
	}


	@Test
	void 자동차_전진() {
		Car car = new Car("test");
		car.moveLocation(new RandomMovingStrategy());
		assertThat(car.carLocation()).isGreaterThanOrEqualTo(DEFAULT_LOCATION);
	}

}
