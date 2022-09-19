package racing_car.step1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
    @DisplayName("Set의 size() 테스트")
    void set_size() {
        assertThat(numbers.size()).isEqualTo(3);
    }
    
    @Nested
    class SetContains {
        @DisplayName("Set contains() 테스트")
        @RepeatedTest(value = 3, name = "{displayName} : {currentRepetition}")
        void contains(RepetitionInfo repetitionInfo) {
            assertThat(numbers.contains(repetitionInfo.getCurrentRepetition())).isTrue();
        }
        
        @DisplayName("Set contains() ture, false 테스트")
        @ParameterizedTest(name = "{displayName} : {0}, {1}")
        @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
        void contains_true_and_false(int element, boolean check) {
            assertThat(numbers.contains(element)).isEqualTo(check);
        }
    }
}
