package study.carrace.step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Set Collection에 대한 학습 테스트")
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
    @DisplayName("요구사항 1 - size() 메소드를 활용해 Set의 크기 확인")
    void size() {
        // when
        int size = numbers.size();

        // then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest(name = "[{index}/3] {displayName}")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항 2 - contains() 메소드를 활용해 1,2,3의 값이 존재하는지 확인")
    public void contains1(int value) {
        // then
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest(name = "[{index}/5] {displayName}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("요구사항 3 - contains() 메소드를 활용해 1,2,3의 값이 존재하고 4,5 값이 부재하는지 확인")
    void contains2(int value, boolean expected) {
        // then
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }
}
