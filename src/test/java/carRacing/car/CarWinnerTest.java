package carRacing.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarWinnerTest {

	@DisplayName("position에 따라 1명 이상의 우승자를 구할 수 있다")
	@Test
	void getWinnerList() {
		Car pobi = new Car(3, "pobi");
		Car geun = new Car(4, "geun");
		Car lee = new Car(4, "lee");
		List<Car> carList = new ArrayList<>();
		carList.add(pobi);
		carList.add(geun);
		carList.add(lee);

		CarWinner carWinner = new CarWinner();
		List<Car> winnerList = carWinner.makeWinnerList(carList);

		assertThat(winnerList.size()).isEqualTo(2);
	}
}