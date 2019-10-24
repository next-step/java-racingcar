package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetTest {
	
	private Set<Integer> numbers = new HashSet<>();

	@BeforeEach
	void setup() {
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	void size() {
		assertThat(numbers).hasSize(4);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void contains(int value) {
		assertThat(numbers).contains(value);
	}

}
