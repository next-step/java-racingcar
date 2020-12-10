package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RecordsTest {

	@ParameterizedTest
	@CsvSource(value = {"3,2,1", "5,6,7", "0,4,2"})
	@DisplayName("저장된 Car들의 position값을 반환한다.")
	void getResultTest(int one, int two, int three) {
		Records records = new Records();
		DefaultNumberGenerator numberGenerator = new DefaultNumberGenerator(5);

		List<Car> cars = new ArrayList<>();
		cars.add(new Car(one, numberGenerator));
		records.add(new Record(cars));

		cars = new ArrayList<>();
		cars.add(new Car(two, numberGenerator));
		records.add(new Record(cars));

		cars = new ArrayList<>();
		cars.add(new Car(three, numberGenerator));
		records.add(new Record(cars));

		assertThat(records.getResult())
			.containsExactly(Collections.singletonList(one), Collections.singletonList(two),
				Collections.singletonList(three));
	}
}
