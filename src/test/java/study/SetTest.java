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
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    //Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
    @DisplayName("set 사이즈 테스트")
    @Test
    void setSizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    //ParameterizedTest를 활용한 중복 코드 제거 테스트를 작성한다.
    @DisplayName("ParameterizedTest, ValueSource을 사용한 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void removeReduplicationTest1(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("ParameterizedTest, CsvSource를 사용한 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void removeReduplicationTest2(int input, boolean expect) {
        assertThat(numbers.contains(input)).isEqualTo(expect);
    }
}
