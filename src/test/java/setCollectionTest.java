import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
public class setCollectionTest {
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
    void 요구사항1(){
        assertThat(numbers.size()).isEqualTo(3);
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void 요구사항2(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true","4:false","5:false"}, delimiter = ':')
    void 요구사항3(String input, String expected){
        int key =Integer.parseInt(input);
        boolean value=Boolean.parseBoolean(expected);
        assertThat(numbers.contains(key)).isEqualTo(value);
    }

}
