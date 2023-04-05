package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("Set Collection에 대한 학습 테스트 - 요구사항1")
    @Test
    void setSize() {
        assertThat(numbers.size()).isEqualTo(3);    //  성공
        //assertThat(numbers.size()).isEqualTo(4);    //  실패(set 은 중복 안됌)
    }

    @DisplayName("Set Collection에 대한 학습 테스트 - 요구사항2")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void setContains(int input) {

        assertThat(numbers.contains(input)).isTrue();

    }

    @DisplayName("Set Collection에 대한 학습 테스트 - 요구사항3")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void setContains(int input, boolean expected) {

        assertThat(numbers.contains(input)).isEqualTo(expected);

    }
}
