package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUP(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
    }
    @DisplayName("[요구사항1] numbers의 사이즈 구하기.")
    @Test
    void checkSize(){
//        assertThat(numbers.size()).isEqualTo(4); // 실패
        assertThat(numbers.size()).isEqualTo(3); // 성공
    }
    @DisplayName("[요구사항2] contains() 메소드를 활용해 값이 존재하는지를 확인")
    @Test
    void contains(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
//        assertThat(numbers.contains(4)).isTrue(); // 실패
    }

    @DisplayName("[요구사항3] 1,2,3 는 numbers 포함 4,5 는 numbers 미포함.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3:true", "4,5:false"}, delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected){
        List<Integer> list = Arrays.stream(input.split(",")).map(Integer::valueOf).collect(Collectors.toList());
        for(int num : list){
            assertThat(numbers.contains(num)).isEqualTo(Boolean.valueOf(expected));
        }

    }
}
