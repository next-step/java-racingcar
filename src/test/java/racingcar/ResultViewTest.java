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
		Car hyundaiCar = Car.createCar("hyundai");
		Car samsungCar = Car.createCar("samsung");
		Car kiaCar = Car.createCar("kia");

		hyundaiCar.move(5);
		hyundaiCar.move(6);
		hyundaiCar.move(7);

		samsungCar.move(4);
		samsungCar.move(5);
		samsungCar.move(6);

		kiaCar.move(3);
		kiaCar.move(2);
		kiaCar.move(7);

		Cars cars = new Cars();
		cars.add(hyundaiCar);
		cars.add(samsungCar);
		cars.add(kiaCar);

		// when
		String viewWinner = ResultView.viewWinner(cars);

		// then
		assertThat(viewWinner).isEqualTo("hyundai, samsung가 최종 우승했습니다.");
	}
}
