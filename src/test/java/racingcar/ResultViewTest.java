package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResultViewTest {
	@DisplayName("전진하는 자동차를 출력할 때 자동차 이름도 같이 출력")
	@Test
	void printWithCarName() {
		// given
		Car audi = Car.createCar("audi");

		// when
		String result = ResultView.carNameAndPositionWithChar(audi, '-');

		// then
		assertThat(result).contains("audi");
	}

	@DisplayName("우승자 출력하기")
	@Test
	void printWinners() {
		// given
		Car audiCar = Car.createCar("audi");
		Car jeepCar = Car.createCar("jeep");
		Car kiaCar = Car.createCar("kia");

		audiCar.move(5);
		audiCar.move(6);
		audiCar.move(7);

		jeepCar.move(4);
		jeepCar.move(5);
		jeepCar.move(6);

		kiaCar.move(3);
		kiaCar.move(2);
		kiaCar.move(7);

		Cars cars = new Cars();
		cars.add(audiCar);
		cars.add(jeepCar);
		cars.add(kiaCar);

		// when
		String viewWinner = ResultView.viewWinner(cars);

		// then
		assertThat(viewWinner).isEqualTo("audi, jeep가 최종 우승했습니다.");
	}
}
