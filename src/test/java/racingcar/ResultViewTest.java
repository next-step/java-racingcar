package racingcar;

import domain.Car;
import domain.Cars;
import domain.Name;
import domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResultViewTest {
	@DisplayName("전진하는 자동차를 출력할 때 자동차 이름도 같이 출력")
	@Test
	void printWithCarName() {
		// given
		Car audi = Car.createCar(new Name("audi"));

		// when
		String result = ResultView.carNameAndPositionWithChar(audi, '-');

		// then
		assertThat(result).contains("audi");
	}

	@DisplayName("우승자 출력하기")
	@Test
	void printWinners() {
		// given
		Car audiCar = new Car(new Name("audi"), new Position(5));
		Car jeepCar = new Car(new Name("jeep"), new Position(5));
		Car kiaCar = new Car(new Name("kia"), new Position(4));

		List<Car> carList = new ArrayList<>();
		carList.add(audiCar);
		carList.add(jeepCar);
		carList.add(kiaCar);
		Cars cars = Cars.createCars(carList);


		// when
		String viewWinner = ResultView.viewWinner(cars);

		// then
		assertThat(viewWinner).isEqualTo("audi, jeep가 최종 우승했습니다.");
	}
}
