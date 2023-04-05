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
    void setup() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("set 크기 확인 테스트")
    public void set_size_테스트() throws Exception {
        assertThat(numbers).size().isEqualTo(3);
    }

    @DisplayName("set contains를 이용 값 확인 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void set_contains_테스트(int number) throws Exception {
        assertThat(numbers.contains(number)).isTrue();

    }

    @DisplayName("set contains를 이용 값 확인 테스트 - false 케이스 추가")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
