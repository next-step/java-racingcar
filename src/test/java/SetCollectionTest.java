import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetCollectionTest {
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
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
    void sizeTest(){
        assertThat(numbers).hasSize(3);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.")
    void useParameterizedTest(int number) {
        assertThat(numbers).contains(number);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("contains 메소드 시 1, 2, 3값은 true / 4,5 값은 false가 반환되는 테스트를 하나의 Test Case로 구현한다.")
    void useCsvSource(int number, boolean expected){
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
