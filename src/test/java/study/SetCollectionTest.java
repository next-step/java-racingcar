package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    // ---요구사항1---
    // size() 메소드를 이용해 Set의 크기 확인하기
    @Test
    @DisplayName("요구사항1_size()메소드 이용하기")
    void size(){
        assertThat(numbers).hasSize(3);
    }

    // ---요구사항2---
    // contains()를 이용한 값 확인 및 ParameterizedTest를 활용한 중복제거
    @Test
    @DisplayName("요구사항2_contains()를 이용한 값 확인")
    void contains(){
        assertThat(numbers).contains(1,2,3);
    }

    // ※질문
    // ParameterizedTest를 사용하면 DisplayName은 무시되는건가?
    @ParameterizedTest(name = "{0}ParameterizedTest를 활용한 중복제거")
    @ValueSource(ints = {1, 2, 3})
    void ParameterizedTest(int input){
        assertThat(numbers.contains(input)).isTrue();
    }

    // ---요구사항3---
    // 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현하기
    @DisplayName("요구사항3_입력 값에 따라 결과 값이 다른 경우에 대한 테스트")
    @ParameterizedTest(name = "{0}요구사항3_입력 값에 따라 결과 값이 다른 경우에 대한 테스트")
    @CsvSource(value = {"1:true", "2:true", "3:true"}, delimiter = ':')
    void ParameterizedTest02(String input, String expected){
        int testData = Integer.parseInt(input);
        boolean result = numbers.contains(testData);
        assertThat(result).isEqualTo(Boolean.parseBoolean(expected));
    }

}
