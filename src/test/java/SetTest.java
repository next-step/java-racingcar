import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
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
    @DisplayName("size 메소드는 자료구조에 실제로 들어있는 유니크한 원소의 개수를 리턴한다")
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest()
    @DisplayName("contains 메소드는 해당 원소가 자료구조에 들어있을 경우 true 를 리턴한다")
    @ValueSource(ints = {1, 2, 3})
    void given_containingValues_whenCallingContains_thenAlwaysTrue(int inputData) {
        assertThat(numbers).contains(inputData);
    }

    @ParameterizedTest
    @DisplayName("contains 메서드는 해당 원소가 자료구조에 들어있지 않을 경우 false 를 리턴한다")
    @NullSource
    @ValueSource(ints = {4, 5})
    void given_notContainingValues_whenCallingContains_thenAlwaysFalse(Integer inputData) {
        assertThat(numbers).doesNotContain(inputData);
    }

    @ParameterizedTest
    @DisplayName("contains 메소드는 해당 원소가 자료구조에 들어있을 경우 true 를, 들어있지 않을 경우 false 를 리턴한다")
    @CsvSource(value = {"1:true", "2:true", "4:false", "5:false"}, delimiter = ':')
    void given_multipleValues_whenCallingContains_thenSomeAreTureAndSomeAreFalse(int inputData,
        Boolean expectedValue) {
        assertThat(numbers.contains(inputData))
            .isEqualTo(expectedValue);
    }
}
