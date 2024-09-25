import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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

    @Nested
    @DisplayName("첫번째 요구사항 클래스")
    class UsingSizeTest {
        /**
         * 요구사항 : size() 메서드를 활용해서 Set의 크기 확인 테스트 구현
         */
        @Test
        @DisplayName(value = "Size()메서드로 크기 확인 테스트")
        public void checkSizeEqualTest() {
            assertThat(numbers).hasSize(3);
        }
    }

    @Nested
    @DisplayName("두번째 요구사항 클래스")
    class UsingParameterizedTest {

        @ParameterizedTest(name =  "1,2,3값 존재여부 ParameterizedTest로 중복 제거 테스트 {index}번쨰값 : {0}")
        @ValueSource(ints = {1, 2, 3})
        void contains(int number) {
            assertThat(numbers.contains(number)).isTrue();
        }
    }

    @Nested
    @DisplayName("세번째 요구사항 클래스")
    class ParameterizeWithCsvSourceTest {

        @ParameterizedTest(name =  "parameterizedTest 실패케이스 테스트 {index}번쨰값 : {0}")
        @CsvSource({"1","2","3","4","5"})
        void containsIncludeFalseData(int number) {
            assertThat(numbers.contains(number)).isTrue();
        }

    }

}

