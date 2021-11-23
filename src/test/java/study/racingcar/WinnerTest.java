package study.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.racingcar.domain.Car;
import study.racingcar.domain.Winner;

public class WinnerTest {

	private Winner winner;

	@BeforeEach
	void setUp(){

		Car car1 = new Car("pobi");
		car1.go(true);
		car1.go(true);
		car1.go(true);

		Car car2 = new Car("juu");
		car2.go(true);
		car2.go(true);
		car2.go(true);

		Car car3 = new Car("alex");
		car3.go(true);
		car3.go(true);
		car3.go(false);

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);

		winner = new Winner(cars);
	}

	@Test
	@DisplayName("Winner 생성")
	void createWinner(){
		int maxPosition = winner.maxPosition();
		List<String> winners = winner.whoIsWinner(maxPosition);
		String result = String.join(",", winners);

		assertThat(result).isEqualTo("pobi,juu");
	}

	@Test
	@DisplayName("maxPosition 가져오기")
	void getMaxPosition(){
		int position = winner.maxPosition();
		assertThat(position).isEqualTo(3);
	}


}
