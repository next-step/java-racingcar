package carRacing.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarServiceTest {

	public static final Integer CAR_NUM = 1;

	@Test
	@DisplayName("차를 이동시킨다.")
	public void moveCar(){
		carService.initRace(CAR_NUM);
		int current_status = carService.carStatus(CAR_NUM);

		carService.moveCar(CAR_NUM);
		int new_status = carService.carStatus(CAR_NUM);

		Assertions.assertEquals(current_status,new_status);

	}

}
