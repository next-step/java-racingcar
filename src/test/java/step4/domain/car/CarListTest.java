package step4.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4.domain.view.UserInput;

class CarListTest {
	private final static int TEST_MOVE_COUNT = 3;
	private final static int TEST_CAR_COUNT = 5;
	private final static String TEST_CAR_STRING = "a,b,c,d,e";
	private UserInput userInput;

	@BeforeEach
	void setUp() {
		userInput = new UserInput(TEST_MOVE_COUNT, TEST_CAR_STRING);
	}

	@Test
	@DisplayName("자동차는 입력받은 이름의 개수만큼 생성되는지 체크하는 테스트")
	void carCountTest() {
		CarList cars = CarList.from(userInput.getNameList());
		for (Car car : cars.getList()) {
			assertThat(car).isNotNull();
		}
		assertThat(cars.getSize()).isEqualTo(TEST_CAR_COUNT);
	}

	@Test
	@DisplayName("position이 제일 높은 사람을 우승자로 뽑는 기능 테스트")
	void getWinnerTest() {
		CarList carList = CarList.from(userInput.getNameList());
		for (int i = 0; i < carList.getSize(); i++) {
			for (int j = 0; j < i; j++) {
				carList.getList().get(i).move(true);
			}
		}
		List<Car> winners = carList.getWinner();
		assertThat(winners.size()).isEqualTo(1);
		for (Car winner : winners) {
			assertThat(winner.getCurrentPosition()).isEqualTo(4);
		}
	}

	@Test
	@DisplayName("position이 제일 높은 사람이 두명 이상일 때 동시 우승자로 뽑는 기능 테스트")
	void getMultipleWinnerTest() {
		CarList carList = CarList.from(userInput.getNameList());
		for (Car car : carList.getList()) {
			car.move(true);
		}
		List<Car> winners = carList.getWinner();
		assertThat(winners.size()).isEqualTo(TEST_CAR_COUNT);
	}

}