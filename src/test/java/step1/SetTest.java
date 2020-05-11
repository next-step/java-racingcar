package step1;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	// 요구사항1
	@Test
	void size() {
		assertThat(numbers.size()).isEqualTo(3);
	}
}
