package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

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

    @DisplayName("size() 메소드가 올바른 set의 크기를 반환하는지 검사한다.")
    @Test
    void size() {
        Assertions.assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "set이 추가한 값을 포함하고 있는지 검사한다.")
    @ValueSource(ints = {1,2,3})
    void contains(int num){
        Assertions.assertThat(numbers.contains(num)).isTrue();
    }


    private static Stream<Arguments> providesForIsContains(){
        return Stream.of(
                Arguments.of(1,true),
                Arguments.of(2,true),
                Arguments.of(3,true),
                Arguments.of(4,false),
                Arguments.of(5,false)
        );
    }

    @ParameterizedTest(name = "set이 추가한 값을 포함하고 있는지 성공하는 케이스와 실패하는 케이스를 테스트한다.")
    @MethodSource("providesForIsContains")
    void isContains(int num, boolean expected){
        Assertions.assertThat(numbers.contains(num)).isEqualTo(expected);
    }

}
