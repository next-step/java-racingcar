package study;

import org.assertj.core.internal.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

    }

    @Test
    @DisplayName("SetClass 요구사항 1 : Set 크기를 확인하는 인터페이스를 구현하라")
    void setTest1(){
        assertThat( numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("SetClass 요구사항 2 : ParameterizedTest를 활용해 중복 코드를 제거")
    @ValueSource(ints = {1, 2, 3} )
    void setTest2(int input) {
        assertTrue(numbers.contains(input));
    }

    @ParameterizedTest
    @DisplayName("SetClass 요구사항 3 : 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현")
    @CsvSource(value = {"1:true", "2:true", "3:true", "true:false", "4:false", "5:false"} , delimiter = ':')
    void setTest3(int input, String expected){
        assertThat(numbers.contains(input)).isEqualTo(Boolean.valueOf(expected));
    }

}
