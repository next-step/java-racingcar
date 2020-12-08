package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.car.Car;
import racing.car.MoveForwardStrategy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class RacingNotifyViewTest {

	private RacingNotifyView racingNotifyView;
	private Random random;

	@BeforeEach
	void setUp() {
		racingNotifyView = new RacingNotifyView();
		random = new Random();
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 5, 999})
	@DisplayName("현재 레이스의 상태를 표시할 때 exception 이 나지 않는지 체크")
	void notifyRace(int carNum) {
		// given
		List<Car> carList = random.ints(carNum, 0, 5)
				.mapToObj(this::createRandomPositionCar)
				.collect(Collectors.toList());
		RacingStatus racingStatus = new RacingStatus(carList);

		// when
		racingNotifyView.notifyRace(racingStatus);
	}

	private Car createRandomPositionCar(int position) {
		Car car = new Car(createAlwaysMoveForwardStrategy());
		for (int i = 0; i < position; i++) {
			car.getMoveForwardChance();
		}
		return car;
	}

	private static MoveForwardStrategy createAlwaysMoveForwardStrategy() {
		return new MoveForwardStrategy() {
			@Override
			public int createMoveForwardChance() {
				return 0;
			}

			@Override
			public boolean isSatisfiedToMoveForward(int chance) {
				return true;
			}
		};
	}

}