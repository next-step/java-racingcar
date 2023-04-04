package edu.nextstep.camp.study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    public void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    public void setSizeTest(){
        int setSize = numbers.size();

        assertThat(setSize)
            .isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource( ints = {1,2,3})
    public void setContainsTrueTest(int number) {
        assertThat( numbers.contains(number) )
            .isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void setContainsTrueOrFalseTest(int number, boolean isContain) {
        assertThat( numbers.contains(number) )
            .isEqualTo(isContain);
    }
}
