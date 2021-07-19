import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Set Collection에 대한 학습 테스트")
class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size() 메서드로 Set의 크기를 확인한다.")
    @Test
    void check_set_size() {
        //given, when, then
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("contains() 메서드로 값 1,2,3이 Set에 존재하는지 확인한다.")
    @ParameterizedTest(name = "Set은 {0}을(를) 포함한다.")
    @ValueSource(ints = {1, 2, 3})
    void check_set_items(int number) {
        //given, when, then
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("contains() 메서드로 입력 값에 따라 결과 값이 다른 경우에 대한 테스트를 구현한다.")
    @ParameterizedTest(name = "Set의 {0} 포함 여부는 {1}다.")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void check_set_items_with_source(int number, boolean result) {
        //given, when, then
        assertThat(numbers.contains(number)).isEqualTo(result);
    }

}