package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SetCollectionTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void set_size_test(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void parameterized_test(int parameter){
        assertThat(numbers.contains(parameter)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value={"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contain_test_with_csv_source(int source, boolean expected){
        assertThat(numbers.contains(source)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideNumber")
    void contain_test_with_method_source(int provided, boolean expected){
        assertThat(numbers.contains(provided)).isEqualTo(expected);
    }


    private static Stream<Arguments> provideNumber(){
        return Stream.of(
            Arguments.of(1, true),
            Arguments.of(2, true),
            Arguments.of(3, true),
            Arguments.of(4, false),
            Arguments.of(5, false)
        );
    }

}































