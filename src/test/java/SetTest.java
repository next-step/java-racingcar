import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("1. Set의 size() 메소드를 활용해 Set의 크기 확인")
    @Test
    void testCheckSetSize() {
        int sizeOfSet = numbers.size();
        assertThat(sizeOfSet).isEqualTo(3);
    }

    @DisplayName("2. Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인 - 중복코드 제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testSetContains(int num) {
        assertThat(numbers).contains(num);
    }

}
