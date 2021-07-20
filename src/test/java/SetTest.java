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
import static org.junit.jupiter.api.Assertions.assertEquals;

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


    @Test
    @DisplayName("size()를 통한 Set 중복 불가 확인")
    void sizeTest() {
        // given, when -> 메서드 밖에서 지정
        // then
        int setSize = numbers.size();
        assertThat(setSize).isEqualTo(3);
    }

    @Test
    @DisplayName("contains()를 통한 원소 확인")
    void containsTest() {
        // given, when -> 메서드 밖에서 지정
        // then
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("contains()를 통한 원소 확인_@ParameterizedTest 를 통한 코드 중복 최소화")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void improvedContainsTest(int number) {
        // given, when -> 메서드 밖에서 지정
        // then
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("@ParameterizedTest, @CsvSource 를 이용한 각기 다른 결과값 Test")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"}) // CSV : Comma Separated Value
    void containsTestWithCsvSource(int input, boolean expected) {
        // given, when -> 메서드 밖에서 지정
        // then
        boolean actualResult = numbers.contains(input);
        assertEquals(expected, actualResult);
    }
}
