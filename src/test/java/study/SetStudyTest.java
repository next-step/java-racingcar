package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetStudyTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
    @Test
    void checkSize() {
        final int setSize = numbers.size();
        int expectedSize = 3;

        assertThat(setSize).isEqualTo(expectedSize);
    }

    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인, " +
            "값이 존재하면 true, 존재하지 않으면 false를 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {"1:true", "2:true", "3:true", "4:false", "5:false"})
    void containsTrueFalseTest(String token) {
        final String[] tokens = token.split(":");
        final int number = Integer.parseInt(tokens[0]);
        final boolean containResult = Boolean.parseBoolean(tokens[1]);

        assertThat(numbers.contains(number)).isEqualTo(containResult);
    }
}
