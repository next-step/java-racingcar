package carRacing.level3;

import static org.assertj.core.api.Assertions.assertThat;
import carRacing.level3.model.Cars;
import carRacing.level3.model.Location;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	void 전략이_참이면_움직인다() {
		List<String> carNameList = new ArrayList<>();
		carNameList.add("car1");
		carNameList.add("car2");

		Cars cars = Cars.create(carNameList);
		cars.moveCarLocation(new FixMovingStrategy());

		assertThat(cars.carLocation(0)).isEqualTo(new Location(1));

	}


}
