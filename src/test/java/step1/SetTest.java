package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @DisplayName("Set의 크기를 확인했을 때 3이 나와야 한다")
    public void Set의_크기를_확인했을_때_3이_나와야_한다() {
        //given
        //when
        //then
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "Set을 확인하였을 때 전달된 원소인 {arguments}를 포함해야 한다")
    @ValueSource(ints = {1, 2, 3})
    public void Set을_확인하였을_때_전달된_원소를_모두_포함해야_한다(int number) {
        //given
        //when
        //then
        assertTrue(numbers.contains(number));
    }

    @ParameterizedTest(name = "Set을 확인하였을 때 전달된 원소가 {arguments} 관계인지 확인한다")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void Set을_확인하였을_때_전달된_원소들의_관계를_모두_만족해야_한다(int input, boolean expected) {
        //given
        //when
        //then
        assertEquals(numbers.contains(input), expected);
    }
}
