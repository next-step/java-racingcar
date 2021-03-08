package study;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("[size] 중복 제거한 개수가 나오는지 테스트합니다.")
    void sizeEqualsNumberWithoutDuplication() {
        //given
        int expectedSize = 3;

        //when
        int numbersSize = numbers.size();

        //then
        assertEquals(numbersSize, expectedSize);
    }

    @DisplayName("contains 테스트 - 1, 2, 3의 값이 존재하는지를 확인")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void containsTrue(int trueInput) {
        //given

        //when
        boolean isTrueContains = numbers.contains(trueInput);

        //then
        assertTrue(isTrueContains);
    }

    @DisplayName("contains 테스트 - 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsAllKeyCase(int inputKey, boolean expectedValue) {
        //given

        //when
        boolean isContainsKey = numbers.contains(inputKey);

        //then
        assertEquals(isContainsKey, expectedValue);
    }

}