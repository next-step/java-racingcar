package step1;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;

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
}
