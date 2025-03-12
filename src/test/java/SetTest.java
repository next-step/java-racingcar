import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetTest {

    private Set<Integer> numbers;

    //참고: 테스트를 할때, 상태를 공유하는것은 독립성을 보장할수 없을수 있습니다.
    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항1: Set의 size() 메소드를 활용해 Set의 크기를 확인한다.")
    void size() {
        assertThat(numbers).size().isEqualTo(3);
        //assertThat(numbers).hasSize(3);
    }

    @Test
    @DisplayName("요구사항2: Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인한다.")
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
        //assertThat(numbers).contains(1,2,3);
    }

    //참고: https://www.baeldung.com/parameterized-tests-junit-5
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항2: JUnit의 ParameterizedTest를 활용해 중복 코드를 제거한다.")
    void contains_usingParameterizedTest(int input) {
        assertThat(numbers.contains(input)).isTrue();
        assertThat(numbers).contains(input);
    }

    //참고: https://www.baeldung.com/introduction-to-assertj
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("요구사항3: 입력 값에 따라 결과 값이 다른 경우를 테스트한다. 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환된다.")
    void contains_usingCsvSource(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
