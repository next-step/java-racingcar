package Practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class SetTestTest {

    SetTest setTest;

    @BeforeEach
    void init() {
        setTest = new SetTest();

        setTest.numbers.add(1);
        setTest.numbers.add(1);
        setTest.numbers.add(2);
        setTest.numbers.add(3);
    }

    @Test
    void setSizeCheck() {
        Assertions.assertThat(setTest.numbers.size()).isEqualTo(3);
    }

//    @Test
    @DisplayName("테스트 반복하기")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void containsCheck(int num) {
        Assertions.assertThat(setTest.numbers.contains(num)).isEqualTo(true);
        Assertions.assertThat(setTest.numbers.contains(num)).isTrue();
    }

    @DisplayName("결과를 지정한 반복 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
    void containsCheckt2(int num, Boolean expected) {
        Assertions.assertThat(setTest.numbers.contains(num)).isEqualTo(expected);
        assertEquals(expected, setTest.numbers.contains(num));
    }
}