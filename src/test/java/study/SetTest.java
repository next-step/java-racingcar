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

@DisplayName("Set Collection 에 대한 학습 테스트")
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
    @DisplayName("요구사항1 - Set 의 크기 확인")
    void checkSetSizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("요구사항2 - Set 의 contains()를 활용해 Set 에 존재하는지 확인")
    @ParameterizedTest(name = "{displayName} -> \"{0}\"")
    @ValueSource(ints = {1, 2, 3})
    void containInSetTestV1(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("요구사항3 - Set 의 contains()를 활용해 Set 에 존재하는지 확인")
    @ParameterizedTest(name = "{displayName} -> \"{0} = {1}\"")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containInSetTestV2(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
