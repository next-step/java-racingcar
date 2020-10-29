package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    // Test Case 구현

    @Test
    @DisplayName("Set의 크기 확인 테스트")
    public void sizeTest(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set의 파라미터 확인 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void containsTest(int input){
        assertTrue(numbers.contains(input));
    }

    @DisplayName("입력값에 따라 true뿐 아니라 false도 검사 가능한 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void containsByConditionTest(int inputNumber, boolean inputBool){
        assertThat(numbers.contains(inputNumber)).isEqualTo(inputBool);
    }
}
