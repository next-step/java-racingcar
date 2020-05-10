package setCollectionTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("요구사항 1 : size 메소드를 활용한 Set Collection의 사이즈 확인 테스트")
    void setCollectionSizeTest() {
    	assertThat(numbers.size()).isEqualTo(3);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("요구사항 2 : jUnit ParameterizedTest를 활용한 Set (only true)")
    void setCollectionContainsTest(int inputValue) {
    	assertThat(numbers.contains(inputValue)).isTrue();
    }
    
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "4,false", "3,true"})
    @DisplayName("요구사항 3 : jUnit ParameterizedTest를 활용한 Set (mix)")
    void setCollectionContainsTest(int inputValue, boolean expectedValue) {
    	assertThat(numbers.contains(inputValue)).isEqualTo(expectedValue);
    }
}
