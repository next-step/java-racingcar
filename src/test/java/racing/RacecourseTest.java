package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("경주장 테스트")
class RacecourseTest {

	@Test
	@DisplayName("경주장 생성 및 초기화 테스트")
	void createRacecourseTest() {
		Racecourse racecourse = new Racecourse();
		racecourse.init(new Command(5, "pobi,crong,honux"));
		assertThat(racecourse.getCarsSize()).isEqualTo(3);
		assertThat(racecourse.getCount()).isEqualTo(5);
	}

	@Test
	@DisplayName("전체 자동차 이동 테스트")
	void racecourseMoveAllTest() {
		Racecourse racecourse = new Racecourse();
		racecourse.init(new Command(5, "pobi,crong,honux"));
		racecourse.moveAll();
	}

	@Test
	@DisplayName("경주장 실행 테스트")
	void racecourseRunTest() {
		Racecourse racecourse = new Racecourse();
		racecourse.init(new Command(5, "pobi,crong,honux"));
		racecourse.run();
	}

	@Test
	@DisplayName("경주장 결과 실패 테스트")
	void racecourseGetWinnerFailTest() {
		Racecourse racecourse = new Racecourse();
		assertThatIllegalArgumentException().isThrownBy(racecourse::getWinners)
											.withMessage("참가하는 자동차가 없습니다.");
	}
	@Test
	@DisplayName("경주장 결과 확인 : 단일 우승자")
	void racecourseGetWinnerTest() {
		Car honux = makeCar("honux", 3);
		Car donny = makeCar("donny", 2);
		Car tony = makeCar("tony", 4);

		Racecourse racecourse = new Racecourse();
		racecourse.join(honux);
		racecourse.join(donny);
		racecourse.join(tony);

		Winners winners = racecourse.getWinners();
		assertThat(winners.getWinnerNames()).isEqualTo(tony.getName());
	}

	@Test
	@DisplayName("경주장 결과 확인 : 복수 우승자")
	void racecourseGetWinnersTest() {
		Car honux = makeCar("honux", 2);
		Car donny = makeCar("donny", 2);
		Car tony = makeCar("tony", 1);

		Racecourse racecourse = new Racecourse();
		racecourse.join(honux);
		racecourse.join(donny);
		racecourse.join(tony);

		Winners winners = racecourse.getWinners();
		String[] winnerNames = winners.getWinnerNames().split(",");

		assertThat(winnerNames).contains(honux.getName());
		assertThat(winnerNames).contains(donny.getName());
	}

	private Car makeCar(String name, int move) {
		Car car = new Car(name);
		MoveStatus status = MoveStatus.FORWARD;
		MoveCondition condition = new MoveCondition(status);
		for (int i = 0; i < move; i++) {
			car.move(condition);
		}
		return car;
	}
}