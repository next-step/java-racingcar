package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    public void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set 크기 계산 테스트")
    public void setSizeTest() {
        assertThat(numbers.size())
                .isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set.contains 테스트")
    public void containsTest(int findingTarget) {
        assertThat(numbers.contains(findingTarget))
                .as("numbers에서 원소 %d 찾기 시도", findingTarget)
                .isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    @DisplayName("Set.contains 복합 테스트")
    public void complexContainsTest(int findingTarget, boolean expectedFindingResult) {
        assertThat(numbers.contains(findingTarget))
                .as("numbers에서 원소 %d 찾기 시도", findingTarget)
                .isEqualTo(expectedFindingResult);
    }

}
