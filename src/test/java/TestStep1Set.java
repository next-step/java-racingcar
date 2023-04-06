import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

public class TestStep1Set {
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
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인")
    void checkSetSize() {
        Assertions.assertEquals(numbers.size(),3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인")
    void checkContainAll(int inputNumber) {
        Assertions.assertTrue(numbers.contains(inputNumber));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true","3:true","4:false","5:false"}, delimiter = ':')
    @DisplayName("입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현")
    void checkIfContain(int inputNumber, boolean ifContain) {
        Assertions.assertEquals(numbers.contains(inputNumber), ifContain);
    }





}
