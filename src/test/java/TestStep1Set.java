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
    @DisplayName("req1")
    void checkSetSize() {
        Assertions.assertEquals(numbers.size(),3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("req2")
    void checkContainAll(int inputNumber) {
        Assertions.assertTrue(numbers.contains(inputNumber));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true","3:true","4:false","5:false"}, delimiter = ':')
    @DisplayName("req3")
    void checkIfContain(int inputNumber, boolean ifContain) {
        Assertions.assertEquals(numbers.contains(inputNumber), ifContain);
    }





}
