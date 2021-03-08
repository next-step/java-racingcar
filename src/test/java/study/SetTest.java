package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    void setSizeTest(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    /*
        @ParameterizedTest
            여러 argument 를 이용해 테스트를 여러번 돌릴 수 있는 테스트 기능
            사용 하기위해서는 @Test 어노테이션은 제거
            @ParameterizedTest 사용시 (@ValueSource, @CsvSource) 최소 Source 한개를 사용해야한다

        @ValueSource : 해당 annotation 에 지정한 배열을 파라미터 값으로 순서대로 넘겨준다.
    */
    @ParameterizedTest
    @ValueSource(ints = {1,1,2,3})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    /*
        @CsvSource
            - 지정한 배열을 파라미터 값으로 순서대로 넘겨준다.
            - 작은 따옴표로 구분을 한다 -> 구분자 변경 시 delimiter 를 사용한다
     */
    @ParameterizedTest
    @CsvSource(value = {"1,2,3:true", "4,5:false"}, delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, boolean active){
        assertThat("1,2,3".contains(input)).isEqualTo(active);
    }
}
