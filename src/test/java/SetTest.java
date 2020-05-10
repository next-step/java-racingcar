import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}
