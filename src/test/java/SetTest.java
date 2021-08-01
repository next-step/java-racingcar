import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

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
    @DisplayName("Set 크기 확인")
    void 요구사항1(){
        int setSize = numbers.size();
        assertThat(setSize).isEqualTo(3);
    }

    @Test
    @DisplayName(("1,2,3 존재 유무 확인"))
    void 요구사항2(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName(("1,2,3 존재 유무 확인 ParameterizedTest 사용"))
    void 요구사항2_ParameterizedTest(int number){
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/setTest.csv")
    @DisplayName(("1,2,3 존재 유무 확인 ParameterizedTest 사용"))
    void 요구사항3_ParameterizedTest_csv(int number, boolean actualValue){
        assertThat(numbers.contains(number)).isEqualTo(actualValue);
    }
}
