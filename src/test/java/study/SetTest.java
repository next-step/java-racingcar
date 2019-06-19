package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SetTest {
    private Set numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("요구사항 1: Set의 size를 확인한다.")
    @Test
    public void setSizeTest() {
        assertThat(numbers.size())
                .isEqualTo(3);
    }

    @DisplayName("요구사항 2: Set Collection의 중복제거를 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void duplicationTest(int i) {
        //given
        numbers.add(i);
        //when & then
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("요구사항 3: 1,2,3은 성공, 4,5는 실패하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false"}, delimiter = ':')
    public void containsTest(int no, boolean expected) {
        assertThat(numbers.contains(no)).isEqualTo(expected);
    }

}
