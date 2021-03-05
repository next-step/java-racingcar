package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetCollectionTest {
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
	@DisplayName("step1.Test Set Collection size")
	void size() {
		assertThat(numbers).size().isGreaterThan(2)
								  .isLessThanOrEqualTo(3);
		
		//2021-03-05 피드백 반영
		assertThat(numbers.size()).isEqualTo(3);
	}
	
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("step1.Test Set Collection contains value using @ParameterizedTest")
    void contains(int testNumber) {
        assertThat(numbers.contains(testNumber)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("step1.Test Set Collection contains value using @CsvSource")
    void contains(int testNumber, boolean expect) {
        assertThat(numbers.contains(testNumber)).isEqualTo(expect);
    }
}
