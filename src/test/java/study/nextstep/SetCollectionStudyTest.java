package study.nextstep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetCollectionStudyTest {
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
    @DisplayName("size() 메소드를 활용해 Set의 크기를 확인하는 테스트")
    public void testSizeMethod2ConfirmSizeOfSet(){
        assertThat(numbers.size()).isEqualTo(4);
    }
}
