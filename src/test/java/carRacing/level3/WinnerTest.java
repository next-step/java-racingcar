package carRacing.level3;

import static carRacing.level3.model.Cars.addCarList;
import static org.assertj.core.api.Assertions.assertThat;

import carRacing.level3.model.Car;
import carRacing.level3.model.Cars;
import carRacing.level3.model.Winner;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WinnerTest {

	@Test
	void 우승자_구하기(){
		Winner winner = new Winner();

		List<Car> carList = Arrays.asList(new Car("car1",1),new Car("car2",0));
		Cars cars = addCarList(carList);

		List<String>winnerList = Arrays.asList("car1");
		assertThat(winner.decideWinner(cars)).isEqualTo(new Winner(winnerList));

	}

}
