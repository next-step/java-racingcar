package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

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

    // TEST코드
    @Test
    public void test1() {

        Assertions.assertThat(numbers.size()).isEqualTo(5);

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void test2(int number) {

        System.out.print(number);


        Assertions.assertThat(numbers.contains(number)).isEqualTo(true);

    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false" ,"5:false"}, delimiter = ':')
    public void test3(int number, boolean expected) {
//        System.out.println(number);
//        System.out.println(expected);
        Assertions.assertThat(numbers.contains(number)).isEqualTo(expected);

    }
}
