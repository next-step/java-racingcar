import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("컬렉션_테스트")
public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        this.numbers = new HashSet<>();
        this.numbers.add(1);
        this.numbers.add(1);
        this.numbers.add(2);
        this.numbers.add(3);
    }

    @Test
    void 컬렉션_크기_구하기() {
        assertThat(this.numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 숫자_포함여부_확인(int value) {
        assertThat(this.numbers).contains(value);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void 숫자_포함여부_확인(int value, boolean result) {
        assertThat(this.numbers.contains(value)).isEqualTo(result);
    }
}
