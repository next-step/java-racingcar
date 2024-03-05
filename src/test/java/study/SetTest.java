package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

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
    @DisplayName("Set Collection 타입의 numbers의 크기를 확인하는 테스트")
    void testSetSize() {
        int setSize = numbers.size();
        assertThat(setSize).isEqualTo(3);
    }
}