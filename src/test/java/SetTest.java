import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;


@DisplayName("Set Class 들의 Method 들을 테스트하는 코드")
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

    @DisplayName("Set 요구사항 1. size 크기 확인")
    @Test
    void setSizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set 요구사항 2. contains 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int arg) {
//        assertThat(numbers.contains(1)).isTrue();
//        assertThat(numbers.contains(2)).isTrue();
//        assertThat(numbers.contains(3)).isTrue();
        assertThat(numbers.contains(arg)).isTrue();
    }

    @DisplayName("Set 요구사항 3. 입력 값에 따라 결과값이 달라지는 경우 테스트")
    @ParameterizedTest()
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains(int arg, boolean rslt) {
        assertThat(numbers.contains(arg)).isEqualTo(rslt);
    }
}