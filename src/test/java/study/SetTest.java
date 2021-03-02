package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("size() 사용하여 Set 크기 확인 테스트")
    void 요구사항1() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("contains() 사용하여 1,2,3의 값이 존재하는지 테스트")
    void 요구사항2() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void 요구사항2_2(int num) {
        assertTrue(numbers.contains(num));
    }

    @ParameterizedTest
    @CsvSource(value={"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
    void 요구사항3(int num, boolean expected) {
        assertThat(numbers.contains(num)).isEqualTo(expected);
    }
}
