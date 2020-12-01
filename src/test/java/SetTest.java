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
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size 메서드로 Set Collection의 크기를 확인하는 학습 테스트")
    @Test
    void sizeTest() {
        int expectedResult = 3;

        assertThat(numbers.size()).isEqualTo(expectedResult);
    }

    @DisplayName("contains 메서드로 Set Collection에 해당 요소가 존재하는지 확인하는 학습 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsTest(Integer searchTarget, boolean expectedResult) {
        assertThat(numbers.contains(searchTarget)).isEqualTo(expectedResult);
    }
}
