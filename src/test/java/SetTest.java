import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

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

//    요구사항 1
    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현.")
    void sizeTest(){
        int actual = numbers.size();
        int expected = 3;
        assertThat(actual).isEqualTo(expected);

        int wrongExpected = 4;
        assertThat(actual).isNotEqualTo(wrongExpected);
    }

//    요구사항 2
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 중복 코드 없이 구현.")
    void containsTest(int value){
        assertThat(numbers.contains(value)).isTrue();
    }

//    요구사항 3
    @ParameterizedTest
    @CsvSource(value = {"1,2,3:true", "4,5:false"}, delimiter = ':')
    @DisplayName("Set의 contains() 메소드를 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현")
    void containsTestWithDifferentResults(String input, String expectedResult){
        String[] inputComponents = input.split(",");
        int[] valueArray = Stream.of(inputComponents)
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean expected = Boolean.parseBoolean(expectedResult);

        for(int actual : valueArray){
            assertThat(numbers.contains(actual)).isEqualTo(expected);
        }
    }

}