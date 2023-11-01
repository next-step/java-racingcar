package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("split() 메소드로 문자열 분리 테스트")
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");

        String[] result2 = "1".split(",");
        assertThat(result2).contains("1");
    }

    @DisplayName("subString() 메소드를 활용해 원하는 문자만 반환하는지 테스트")
    @Test
    void subString() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt() 메소드가 문자의 위치 값을 벗어나면 Exception을 발생하는지 테스트")
    @Test
    void charAt() {
        String data = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    data.charAt(5);
                }).withMessageMatching("String index out of range: \\d+");
    }

    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 테스트")
    @Test
    void size() {
        int numbersSize = numbers.size();
        assertThat(numbersSize).isEqualTo(3);
    }

    @DisplayName("Set의 contains() 메소드를 활용해 값의 존재를 확인하는 테스트")
    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("@ParameterizedTest와 @ValueSource를 활용해 contains() 테스트의 중복 코드를 제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void parameterizedTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("@ParameterizedTest와 @CsvSource를 활용해 contains() 메소드 성공, 실패 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void csvSource(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
