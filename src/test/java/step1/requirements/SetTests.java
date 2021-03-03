package step1.requirements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetTests {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // *** Set 요구사항 1 ***
    @Test
    @DisplayName("Set Size 구하기")
    public void setSizeTest() {
        int expectedValue = 3;
        int actualValue = numbers.size();
        assertThat(actualValue).isEqualTo(expectedValue);
    }

    // *** Set 요구사항 2 ***
    @DisplayName("Set에 1,2,3 값이 있는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    public void isExistTest(int input) {
        System.out.println(numbers.contains(input)); // 질문
        assertThat(numbers.contains(input)).isTrue();
    }


    // *** Set 요구사항 3 ***
    @DisplayName(" Set에 1,2,3 값이 true, 4,5 false")
    @ParameterizedTest
    @CsvSource(value = {"1:true, 2:true, 3:true, 4:false, 5:false"}, delimiter = ':')
    public void isExistTrueAndFalseTest(int input) {
        
        assertThat(numbers.contains(input)).isTrue();
    }

}
