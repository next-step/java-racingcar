package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.CarList;
import racing.game.Game;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CarListTest {

	static class AlwaysReturn4 extends Random {
		@Override
		public int nextInt() {
			return 4;
		}
	}

	@Test
	@DisplayName("3대의 자동차{A, B, C}가 경주 게임을 완료했을 때 모두 우승한다")
	void all_winner() {
		int cars = 3;
		CarList carList = new CarList(cars, new String[]{"A", "B", "C"});
		Game game = new Game(new AlwaysReturn4());

		carList.moveAll(game.bounds(cars));

		List<String> winners = carList.winners();
		assertThat(winners).contains("A", "B", "C");
		assertThat(winners).hasSize(3);
	}

	@Test
	@DisplayName("3대의 자동차{A, B, C}가 경주 게임을 완료했을 때 A가 우승한다")
	void one_winner() {
		int cars = 3;
		CarList carList = new CarList(cars, new String[]{"A", "B", "C"});

		carList.moveAll(new int[]{4, 3, 3});

		List<String> winners = carList.winners();
		assertThat(winners).contains("A");
		assertThat(winners).hasSize(1);
	}

	@Test
	@DisplayName("자동차의 초기 위치는 모두 1 이다")
	void init() {
		int cars = 3;
		CarList carList = new CarList(cars);
		List<Integer> carListAllPosition = carList.getAllPosition();

		for (Integer position : carListAllPosition) {
			assertThat(position).isEqualTo(1);
		}
	}

	@Test
	@DisplayName("3대의 자동차가 한번에 모두 전진한다")
	void move_all_cars() {
		int cars = 3;
		Game game = new Game(new AlwaysReturn4());
		CarList carList = new CarList(cars);

		carList.moveAll(game.bounds(cars));

		List<Integer> allPosition = carList.getAllPosition();
		for (Integer position : allPosition) {
			assertThat(position).isEqualTo(2);
		}

	}
}
