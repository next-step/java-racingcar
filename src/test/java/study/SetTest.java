package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<Integer>(Arrays.asList(1, 1, 2, 3, 4));

        // 초기화 이후에 변경이 불가한 Set
        // numbers = Collections.unmodifiableSet(new HashSet<Integer>(Arrays.asList(1, 2, 3)));
        // numbers =  Set.of(1, 2, 3); // JAVA 9 부터 사용 가능
    }

    @Test
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "3:true", "4:false"}, delimiter = ':')
    void contains_결과값_테스트(int number, boolean result) {
        assertEquals(result, numbers.contains(number));
    }


}
