package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class RandomGeneratorTest {

	@Test
	public void 랜덤숫자_최대값_생성_검증() {
		List<Integer> randomNumbers = new ArrayList<>();
		for(int index = 0; index < 100; index++) {
			randomNumbers.add(RandomGenerator.getInstance().getRandomPosition());
		}

		assertThat(randomNumbers.stream()
				.filter(randomNumber -> randomNumber <= RandomGenerator.MAX_MOVE_POSITION)
				.collect(Collectors.toList())).hasSameSizeAs(randomNumbers);
	}
}