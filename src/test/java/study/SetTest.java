package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetTest {

    private Set<Integer> numbers;
    private int[] inputNumbers = {1, 1, 2 ,3};

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();

        for (int input :
                inputNumbers) {
            numbers.add(input);
        }
    }

    @Test
    void Set은_중복된_입력값을_하나로_처리한다() {
        List<Integer> counts = getCountWithRemoveDuplicates();

        assertThat(numbers.size()).isEqualTo(counts.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    private List<Integer> getCountWithRemoveDuplicates() {
        List<Integer> counts = new ArrayList<>();
        for (int input :
                inputNumbers) {
            if (!counts.contains(input)) {
                counts.add(input);
            }
        }
        return counts;
    }
}