package racingCar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingCar.domain.Distance;

public class DistanceTest {
	@ParameterizedTest(name = "속력이 {arguments} 주어졌을 때 {arguments} 개의 Distance 객체가 생성된다")
	@ValueSource(ints = { 1, 2, 3, 4, 5 })
	void create_arguments_distance(int speed) {
		List<Distance> distanceList = Distance.from(speed);

		assertThat(distanceList).hasSize(speed);
	}
}
