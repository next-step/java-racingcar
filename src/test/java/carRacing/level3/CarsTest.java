package carRacing.level3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import carRacing.level3.infra.error.NotFoundCarsException;
import carRacing.level3.model.Cars;
import carRacing.level3.model.Location;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

	@Test
	void 전략이_참이면_움직인다() {
		List<String> carNameList = new ArrayList<>();
		carNameList.add("car1");
		carNameList.add("car2");

		Cars cars = Cars.create(carNameList);
		cars.moveCarLocation(new FixMovingStrategy());

		assertThat(cars.carLocation(0)).isEqualTo(new Location(1));
		assertThat(cars.carLocation(1)).isEqualTo(new Location(1));

	}

	@Test
	@DisplayName("최대위치 구하기 테스트")
	void cars가_없으면_에러_반환() {
		List<String> carNameList = new ArrayList<>();

		Cars cars = Cars.create(carNameList);

		assertThatThrownBy(() -> {
			cars.maxCarLocation();
		}).isInstanceOf(NotFoundCarsException.class);


	}
}
