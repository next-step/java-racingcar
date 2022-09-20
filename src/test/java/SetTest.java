import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
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
    @DisplayName("Set.size() 메소드 기능 테스트")
    public void setTest1(){
        assertEquals(numbers.size(), 3);
    }

    @ParameterizedTest
    @DisplayName("Set.contains() 메소드 기능 테스트")
    @ValueSource(ints = {1, 2, 3})
    void setTest2(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Set.contains() 메소드 기능 추가 케이스 테스트")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(int input, String expected) {
        assertEquals(numbers.contains(input), Boolean.valueOf(expected));
    }

}