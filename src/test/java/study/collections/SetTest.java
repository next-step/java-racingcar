package study.collections;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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


	@Test
	@DisplayName("size 메서드는 컬랙션의 길이를 반환한다.")
	void test_size() {
		int expect = 3;
		int result = numbers.size();

		assertThat(result).isEqualTo(expect);
	}

}
