package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
	@Test
	@DisplayName("List<Car> 생성 - 일급 콜렉션")
	void createCars() {
		Car aaa = new Car("aaa");
		Car bbb = new Car("bbb");
		Car ccc = new Car("ccc");

		List<Car> list = Arrays.asList(aaa, bbb, ccc);
		Cars cars = new Cars(list);
		assertThat(cars.getCars().size()).isEqualTo(3);
	}

	@Test
	@DisplayName("우승자 확인")
	void findWinners() {
		Car aaa = new Car("aaa");
		aaa.movingOfRound(3);
		Car bbb = new Car("bbb");
		bbb.movingOfRound(4);
		Cars cars = new Cars(Arrays.asList(aaa, bbb));

		assertThat(cars.findWinner()).containsExactly(bbb);
	}

	@Test
	@DisplayName("우승자 위치 확인")
	void bestPosition() {
		Car aaa = new Car("aaa");
		aaa.movingOfRound(3);
		Car bbb = new Car("bbb");
		bbb.movingOfRound(4);
		Cars cars = new Cars(Arrays.asList(aaa, bbb));

		assertThat(cars.findWinner().get(0).getStatus()).isEqualTo(new Position(1));
	}
}
