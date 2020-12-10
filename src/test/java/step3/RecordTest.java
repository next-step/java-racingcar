package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RecordTest {

	@ParameterizedTest
	@CsvSource(value = {"3,2,1", "5,6,7", "0,4,2"})
	@DisplayName("저장된 Car들의 position값을 반환한다.")
	void getResultTest(int one, int two, int three) {
		DefaultNumberGenerator numberGenerator = new DefaultNumberGenerator(5);
		List<Car> cars = new ArrayList<>();
		cars.add(new Car(one, numberGenerator));
		cars.add(new Car(two, numberGenerator));
		cars.add(new Car(three, numberGenerator));

		Record record = new Record(cars);

		assertThat(record.getResult()).containsExactly(one, two, three);
	}
}
