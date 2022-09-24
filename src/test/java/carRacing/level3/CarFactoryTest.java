package carRacing.level3;

import carRacing.level3.domain.CarFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarFactoryTest {

	public static final Integer CARNUM = 1;

	CarFactory carFactory = new CarFactory();

	@Test
	@DisplayName("처음 라운드는 모두 한칸씩 이동하여 현재 이동 상태는 1이다.")
	void setInitTest() {
		carFactory.setInitStatus(CARNUM);
		int status = carFactory.getCarStatus(CARNUM);
		Assertions.assertEquals(status, 1);
	}

	@Test
	@DisplayName("새로운 이동 상태를 저장한다.")
	void saveStatus(){
		int status = 2;
		carFactory.saveStatus(CARNUM,status);
		carFactory.getCarStatus(CARNUM);
		Assertions.assertEquals(status, 2);
	}

}
