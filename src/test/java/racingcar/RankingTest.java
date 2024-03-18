package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingTest {
	@Test
	@DisplayName("여러 Car 중 position이 가장 높은 Car를 우승자로 반환한다.")
	void getWinner() {
		Car car1 = new Car("car1");
		Car car2 = new Car("car2");
		Car car3 = new Car("car3");

		car1.move();
		car1.move();
		car2.move();

		Ranking ranking = new Ranking(List.of(car1, car2, car3));

		assertThat(ranking.getWinners()).containsExactly(car1);
	}

	@Test
	@DisplayName("position이 가장 높은 Car가 여러 대일 경우 해당 Car들을 모두 반환한다.")
	void whenPositionIsSameThenGetAllCarWithSamePosition() {
		Car car1 = new Car("car1");
		Car car2 = new Car("car2");
		Car car3 = new Car("car3");

		car1.move();
		car1.move();
		car2.move();
		car2.move();

		Ranking ranking = new Ranking(List.of(car1, car2, car3));

		assertThat(ranking.getWinners()).containsExactly(car1, car2);
	}
}
