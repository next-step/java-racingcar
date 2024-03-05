package study;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;
import java.util.Set;

@Description("Set Collection에 대한 학습 테스트")
public class SetTest {

    // Set Collection에 대한 학습 테스트

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

    // 요구사항 1

    // 요구사항 2

    // 요구사항 3
}
