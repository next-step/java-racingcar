package study;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

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
	@DisplayName("요구사항 1 자료구조 Set의 크기를 확인하는 Test")
	void sizeTest() {
		assertThat(numbers.size()).isEqualTo(3);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	@DisplayName("요구사항 2 ParameterizedTest를 활용한 중복코드 제거")
	void isContainsTest(int number) {
		assertThat(numbers).contains(number);
	}
	
}
