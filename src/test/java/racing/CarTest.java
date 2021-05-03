package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 테스트")
public class CarTest {

	@Test
	@DisplayName("자동차 생성 테스트")
	void createCarTest() {
		String name = "honux";
		Car car = new Car(name);
		assertThat(car).isNotNull();
		assertThat(car.getName()).isEqualTo(name);
	}
	@Test
	@DisplayName("자동차 생성 실패 테스트 : 이름이 5자 이상 일 경우")
	void createCarFailTest() {
		assertThatIllegalArgumentException().isThrownBy(() ->new Car("honuxx"));
	}

	@Test
	@DisplayName("자동차 이동 상태 테스트")
	void checkCarMoveStatusTest() {
		Car car = new Car("honux");
		assertThat(car.getMovementStatus()).isEqualTo(MoveStatus.STOP);
	}
	
	@Test
	@DisplayName("자동차 이동 테스트 : 정지")
	void checkCarMoveStopTest() {
		Car car = new Car("honux");
		MoveStatus status = MoveStatus.STOP;
		MoveCondition condition = new MoveCondition(status);
		car.move(condition);
		assertThat(car.getMovementStatus()).isEqualTo(MoveStatus.STOP);
		assertThat(car.getMoveCount()).isEqualTo(0);
	}

	@Test
	@DisplayName("자동차 이동 테스트 : 전진")
	void checkCarMoveForwardTest() {
		Car car = new Car("honux");
		MoveStatus status = MoveStatus.FORWARD;
		MoveCondition condition = new MoveCondition(status);
		car.move(condition);
		assertThat(car.getMovementStatus()).isEqualTo(MoveStatus.FORWARD);
		assertThat(car.getMoveCount()).isEqualTo(1);
	}

	@RepeatedTest(value = 10, name = "{displayName} - {currentRepetition}/{totalRepetitions}")
	@DisplayName("자동차 이동 테스트 : 랜덤")
	void checkCarMoveTest() {
		Car car = new Car("honux");
		MoveCondition condition = new MoveCondition();
		car.move(condition);

		assertThat(car.getMovementStatus()).isEqualTo(condition.getStatus());
		if (condition.getStatus().equals(MoveStatus.FORWARD)) {
			assertThat(car.getMoveCount()).isEqualTo(1);
		}
	}
}
