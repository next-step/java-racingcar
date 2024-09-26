import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach // test를 하기 전 무조건 세팅되는 값
    void setUp() {
        numbers = new HashSet<>();

        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("size() 메서드를 사용해 Set의 크기를 확인한다.")
    void confirmSize() {
        Assertions.assertThat(numbers.size()).isEqualTo(3);
    }

/*    @Test
    void existSet() {
        // Assertions.assertThat(numbers).contains(1,2,3);
        Assertions.assertThat(numbers.contains(1)).isTrue();
        Assertions.assertThat(numbers.contains(2)).isTrue();
        Assertions.assertThat(numbers.contains(3)).isTrue();
    }*/

    @ParameterizedTest // 매개변수 개수에 따라 중복된 코드를 제거해준다
    @ValueSource(ints = {1, 2, 3}) // 투입될 매개변수
    @DisplayName("set은 1,2,3을 다 가지고 있는가?")
    void existSet(int input) {
        Assertions.assertThat(numbers.contains(input)).isTrue();
    }

    /*
     * 입력값에 따라 다른 출력값을 나타내고 싶은 경우는 csvsource를 사용한다
     * */
    @ParameterizedTest
    @CsvSource(value = {"1 : true", "2 : true", "3 : true", "4 : false", "5 : false"}, delimiter = ':')
    void checkTrueOrFalse(int input, boolean output) {
        Assertions.assertThat(numbers.contains(input)).isEqualTo(output);
    }
}
