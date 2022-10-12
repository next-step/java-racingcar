package carRacing.level3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import carRacing.level3.model.Cars;
import carRacing.level3.model.Location;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

	@Test
	void 전략이_참이면_움직인다() {
		List<String> carNameList = Arrays.asList("car1","car2");

		Cars cars = Cars.create(carNameList);
		cars.moveCarLocation(new FixMovingStrategy());

		assertThat(cars.car(0).carLocation()).isEqualTo(new Location(1));
		assertThat(cars.car(1).carLocation()).isEqualTo(new Location(1));

	}

	@Test
	@DisplayName("최대 위치 에러 반환 테스트")
	void 자동차가_비어있으면_에러_반환() {
		List<String> carNameList = new ArrayList<>();

		Cars cars = Cars.create(carNameList);

		assertThatThrownBy(() -> {
			cars.maxLocation();
		}).isInstanceOf(NotFoundMaxLocationException.class);


	}
}
