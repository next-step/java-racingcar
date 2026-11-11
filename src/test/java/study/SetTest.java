package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {

	private Set<Integer> members;

	@BeforeEach
	void setUp() {
		members = new HashSet<>();
		members.add(1);
		members.add(1);
		members.add(2);
		members.add(3);
	}

	@Test
	@DisplayName("set에 같은 값을 추가해도 set의 size는 늘어나지 않는다")
	void size() {
		assertThat(members.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("set에 추가한 1, 2, 3은 contains가 true를 반환한다")
	void contains(int input) {
		assertThat(members.contains(input)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(
		value = {"1,true", "2,true", "3,true", "4,false", "5,false"}
	)
	@DisplayName("Set에 있는 값은 true, 없는 값은 false를 반환한다")
	void containsTrueOrFalse(int input, boolean expected) {
		assertThat(members.contains(input)).isEqualTo(expected);
	}
}
