package carracing.car;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
	@Test
	void winners_threeCars_oneWinners() {
		Car car1 = new Car(10, "abc");
		Car car2 = new Car(9, "abc");
		Car car3 = new Car(8, "abc");

		Winners winners = new Winners(List.of(car1, car2, car3));

		assertThat(winners.winners()).isEqualTo(List.of(car1));
	}

	@Test
	void winners_threeCars_twoWinners() {
		Car car1 = new Car(10, "abc");
		Car car2 = new Car(10, "abc");
		Car car3 = new Car(8, "abc");

		Winners winners = new Winners(List.of(car1, car2, car3));

		assertThat(winners.winners()).isEqualTo(List.of(car1, car2));
	}
}
