package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.helper.CustomArgumentAggregator;
import step1.helper.SetCollectionTestArgument;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetCollectionTest {
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
    public void 컬렉션_Size_확인_테스트() {
        //given
        int expected = 3;

        //when, then
        assertThat(numbers.size()).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{displayName} / value = {0}")
    @ValueSource(ints = {1, 2, 3})
    public void 컬렉션_값_확인_테스트(int input) {
        //given, when, then
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest(name = "{displayName} / value = {0}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void 컬렉션_값_확인_테스트2(@AggregateWith(CustomArgumentAggregator.class) SetCollectionTestArgument arg) {
        //given, when, then
        assertThat(numbers.contains(arg.getInput())).isEqualTo(arg.isExpected());
    }
}
