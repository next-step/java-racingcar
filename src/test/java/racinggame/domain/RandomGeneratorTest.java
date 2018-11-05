package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class RandomGeneratorTest {

	@Test
	public void 랜덤숫자_최대값_생성_검증() {
		RandomGenerator randomGenerator = new RandomGenerator();
		List<Integer> randomNumbers = new ArrayList<>();
		for(int index = 0; index < 100; index++) {
			randomNumbers.add(randomGenerator.getRandomNumber());
		}

		assertThat(randomNumbers.stream()
				.filter(randomNumber -> randomNumber <= RandomGenerator.MAX_MOVE_POSITION)
				.collect(Collectors.toList())).hasSameSizeAs(randomNumbers);
	}
}