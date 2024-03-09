import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jeongheekim
 * @date 3/6/24
 */
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
    @DisplayName("numbers의 size는 3이다.")
    void setSizeTest() {
        Assertions.assertEquals(numbers.size(), 3);
    }
}
