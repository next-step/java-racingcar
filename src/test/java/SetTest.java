import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    // Test Case 구현

    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트")
    public void sizeTest() {

        //when
        int size = numbers.size();

        //then
        assertThat(size).isEqualTo(3);
    }
}
