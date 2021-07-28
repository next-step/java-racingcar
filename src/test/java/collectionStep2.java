import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class collectionStep2 {
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
    public void stringStep1_1() {
        String[] numbers = "1,2".split(",");
        assertThat(numbers).contains("1", "2");
    }

    @Test
    public String stringStep1_2() {
        String numberSub = "(1,2)";
        String numSub = numberSub.substring(1,4);

        return numSub;
    }
    @Test
    @DisplayName("indexExceptionTest")
    public void stringStep1_3() {
            String abc = "abc";
            char abcException = abc.charAt(10);
    }
}
