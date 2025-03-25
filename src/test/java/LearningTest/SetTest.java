package LearningTest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
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

    @Test
    public void size(){ // requirement1
        assertThat(this.numbers.size() == 4);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(int number) { // requirement2
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3:true", "4,5:false"}, delimiter = ':')
    void containsTrueAndFalse(String numArrayString, boolean expected){
        System.out.println(numArrayString);
        int[] numArray = Arrays.stream(numArrayString.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        for(int number : numArray){
            assertThat(numbers.contains(number)).isEqualTo(expected);
        }
    }


}
