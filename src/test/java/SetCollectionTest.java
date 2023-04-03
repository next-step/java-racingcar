import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Set Collection에 대한 학습 테스트")
public class SetCollectionTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        for (int num = 1; num <= 3; num++){
            numbers.add(num);
        }
    }

    @Test
    @DisplayName("size() 메소드로 Set의 크기를 확인할 수 있다")
    public void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }
    
    @ParameterizedTest
    @DisplayName("contains() 메소드로 값의 존재를 확인할 수 있다")
    @ValueSource(ints = {1,2,3})
    public void containsTest1(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }
    
    
    @ParameterizedTest
    @DisplayName("contains() 메소드로 값의 존재 또는 비존재 여부를 확인할 수 있다")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void containsTest2(int value, boolean expected) {
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }
}
