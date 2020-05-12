import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Set Collection에 대한 학습 테스트")
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

    @DisplayName("요구사항 1 - size() 메소드 활용")
    @Test
    public void 요구사항_1() {
        int expectedSize = 3;
        int setSize = numbers.size();

        assertThat(setSize).isEqualTo(expectedSize);
    }

    @DisplayName("요구사항 2 - contains() 메소드 활용 / ParameterizedTest를 이용한 중복 제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void 요구사항_2(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("요구사항 3 - ParameterizedTest사용시 다양한 케이스 적용")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void 요구사항_3(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
