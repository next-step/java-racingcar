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

    @DisplayName("SET 콜렉션은 중복이 제거된 사이즈를 반환한다.")
    @Test
    void size(){
        assertThat(this.numbers.size()).isEqualTo(3);
    }

    @DisplayName("추가한 1,2,3이 존재한다.")
    @ParameterizedTest
    @ValueSource(ints={1,2,3})
    void contains(int argument) {
        assertThat(numbers.contains(argument)).isTrue();
    }

    @DisplayName("요소의 존재를 확인 할수 있다.")
    @ParameterizedTest
    @CsvSource({
        "1,true",
        "2,true",
        "3,true",
        "4,false",
        "5,false"
    })
    void isContains(int element, boolean contains) {
        assertThat(this.numbers.contains(element)).isEqualTo(contains);
    }

}
