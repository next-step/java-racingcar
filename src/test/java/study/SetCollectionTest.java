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

public class SetCollectionTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("메소드 크기 확인")
    @Test
    void checkSetSize(){
        int result = numbers.size();
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("1,2,3값 존재 확인")
    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(4)).isTrue();
    }

    @DisplayName("위 테스트 중복 제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void removeDuplicationContainsClass(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }


    @DisplayName("Contains메소드 True/False 모두 리턴할 수 있도록 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    void returnValidationResult(int number, Boolean expected){
        assertThat(numbers.contains(number)).isTrue().isEqualTo(expected);

    }
}
