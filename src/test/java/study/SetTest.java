package study;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(OrderAnnotation.class)
public class SetTest {
    private Set numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Order(1)
    @DisplayName("요구사항1 : size() 활용하기")
    @Test
    void size() {
        //then
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers).hasSize(3);
    }

    @Order(2)
    @DisplayName("요구사항2 : contains() 활용하기")
    @Test
    void contain() {
        //then
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @Order(3)
    @DisplayName("요구사항2 : contains() 활용하기")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contain2(int number) {
        //then
        assertThat(numbers.contains(number)).isTrue();
    }

    @Order(4)
    @DisplayName("요구사항2 : contains() 활용하기")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false", "6:false"}, delimiter = ':')
    void contain3(int number, boolean expected) {
        //then
        boolean result = numbers.contains(number);
        assertEquals(expected, result);
    }
}