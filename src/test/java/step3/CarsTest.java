package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step3.domain.Car;
import step3.domain.Cars;

public class CarsTest {
	@DisplayName(value = "Cars 동작 테스트")
	@CsvSource("A,B,C")
	@ParameterizedTest
	void raceOneTrial(String carA, String carB, String carC) {
		String[] names = {carA, carB, carC};
		Cars cars = new Cars(names);
		cars.raceOneTrial();
		List<Car> carList = cars.getCars();

		assertThat(carList.size()).isEqualTo(names.length);
	}
}
