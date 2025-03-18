package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Set Collection 테스트")
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

    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
    void 요구사항_1() {
        //given

        //when
        int size = numbers.size();

        //then
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 요구사항_2(int input) {
        //given

        //when
        boolean contains = numbers.contains(input);

        //then
        assertThat(contains).isTrue();
    }

    @DisplayName("주어진 숫자가 집합에 포함되어 있는지 확인합니다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void 요구사항_3(int input, boolean expected) {
        //given

        //when
        boolean contains = numbers.contains(input);

        //then
        assertThat(contains).isEqualTo(expected);
    }
}
