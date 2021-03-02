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

/**
 * 온라인 코드리뷰 요청 1단계 <br/>
 * - 주어진 Set 데이터를 이용하여 Set 인터페이스 API 학습 테스트 <br/>
 * - @ParameterizedTest 를 활용하여 테스트 코드 중복을 제거 학습 <br/>
 * - 위 어노테이션과 함께 사용할 수 있는 @ValueSource, @CsvSource 를 활용하는 학습
 */
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1); // 중복된 값의 추가로 인한 overwrite
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항 1: Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습 테스트")
    void setSizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "{0} 값을 포함되어 있는 지 확인")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항 2: Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습 테스트")
    void setContainsTest(int given) {
        assertThat(numbers.contains(given)).isTrue();
    }

    @ParameterizedTest(name = "{0} 값을 포함되어 있는 지 확인")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항 2: ParameterizedTest를 활용해 위 테스트 코드의 중복 코드를 제거")
    void setContainsParameterizedTest(int given) {
        assertThat(numbers.contains(given)).isTrue();
    }

    @ParameterizedTest(name = "{0} 값이 포함되어 있는지 여부를 판단: {1}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("요구사항 3: 위 테스트에서 입력 값에 따라 true / false 모두 테스트도 가능하도록 구현")
    void setContainsNotValueException(int input, boolean excepted) {
        assertThat(numbers.contains(input)).isEqualTo(excepted);
    }
}
