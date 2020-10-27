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
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Set Collection 학습 테스트")
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
    @DisplayName("1. Set size() 확인")
    public void getSetSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("2-1. 특정 값이 Set에 포함되어있는지 확인")
    public void setContains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest(name = "{0} 은 Set에 포함됨")
    @DisplayName("2-2. 특정 값이 Set에 포함되어있는지 확인(Parameterized Test)")
    @ValueSource(ints = {1, 2, 3})
    public void setContains(int number) {
        assertTrue(numbers.contains(number));
    }

    @ParameterizedTest(name = "{0} 포함여부: {1}")
    @DisplayName("3. 임의의 값이 Set에 포함되어있는지 확인(Parameterized Test)")
    @CsvSource(value={"1,true", "2,true", "3,true","4,false","5,false"}, delimiter = ',')
    public void setContains(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
