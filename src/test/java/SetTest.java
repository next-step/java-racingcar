import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    /**
     * 요구사항 1
     * Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
     */

    @Test
    void sizeTest (){
        assertEquals(3, numbers.size()); // Hash라 중복값(1)은 저장안되므로 사이즈는 3.
    }

    /**
     * 요구사항 2
     * Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
     * 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
     * JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.
     */

    @Test
    void containsTest (){
        assertEquals(true, numbers.contains(1));
        assertEquals(true, numbers.contains(2));
        assertEquals(true, numbers.contains(3));
    }
}