package study;

import org.junit.jupiter.api.BeforeEach;
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

    @Test
    void getSize(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    // 요구사항 2를 구현하였는데 3의 조건에도 맞는 것 같습니다~
    // 혹시 제가 요구사항을 정확하게 이해하지 못한 것일까요~?
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void containsTest(int input){
        assertThat(numbers).contains(input);
    }


}
