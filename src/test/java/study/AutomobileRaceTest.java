package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutomobileRaceTest {

	private List<Car> carList;
	private Stadium stadium;
	private NumberContainer numberContainer;

	@BeforeEach
	void init() {
		numberContainer = new NumberContainer();
		stadium = new Stadium(numberContainer);
		Car car = new Car(0);
		Car car2 = new Car(0);
		Car car3 = new Car(0);
		carList = Arrays.asList(car,car2,car3);
	}

	@DisplayName("스프링에 - 을 이어붙일 때 나오는 결과를 테스트")
	@Test
	void StringAddTest() {
		String str = "";
		String result = "" + "-";
		assertThat("-").isEqualTo(result);
	}

	@DisplayName("자동차가 가는지 결과를 확인하는 테스트")
	@Test
	void goTest() {
		Car car = carList.get(0);
		int currentDistance = car.getDistance();
		car.go();
		int changedDistance = car.getDistance();
		assertThat(currentDistance + 1).isEqualTo(changedDistance);
	}

}
