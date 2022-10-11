package carRacing.level3;

import static carRacing.level3.model.Cars.addCarList;
import static org.assertj.core.api.Assertions.assertThat;

import carRacing.level3.model.Car;
import carRacing.level3.model.CarName;
import carRacing.level3.model.Cars;
import carRacing.level3.model.Location;
import carRacing.level3.model.Winner;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WinnerTest {

	@Test
	void 우승자_구하기(){
		Winner winner = new Winner();

		List<Car> carList = Arrays.asList(new Car(new CarName("car1"),new Location(1)),new Car(new CarName("car2"),new Location(0)));
		Cars cars = addCarList(carList);

		List<String>winnerList = Arrays.asList("car1");
		assertThat(winner.decideWinner(cars)).isEqualTo(new Winner(winnerList));

	}

}
