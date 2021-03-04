package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.racingcar.entity.RandomGenerator;

public class RandomGenratorTest {

	private static final List<Integer> list;

	static {
		list = IntStream.range(0, 10)
			.boxed()
			.collect(Collectors.toList());
	}

	@Test
	@DisplayName("Random 숫자 0-9")
	@RepeatedTest(5)
	void random_숫자_테스트() {
		int random = new Random().nextInt(10);

		assertThat(list.contains(random))
			.isEqualTo(true);
	}

	@Test
	@DisplayName("RandomGenerator test")
	void RandomGenerator_Test() {
		Arrays.asList(
			RandomGenerator.generateRandomNumber(),
			RandomGenerator.generateRandomNumber(),
			RandomGenerator.generateRandomNumber(),
			RandomGenerator.generateRandomNumber()
		).forEach(System.out::println);
	}
}
