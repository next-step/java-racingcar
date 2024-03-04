package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {

    private Set<Integer> sutNumbers;

    @BeforeEach
    void setUp() {
        sutNumbers = new HashSet<>();
        sutNumbers.add(1);
        sutNumbers.add(1);
        sutNumbers.add(2);
        sutNumbers.add(3);
    }

    @Test
    @DisplayName("Set의 size 메소드를 수행할 경우 numbers의 크기가 출력되어야한다.")
    public void SizeMethod_Should_Return_NumberSize() throws Exception{
        //given
        //when
        int size = sutNumbers.size();
        int expectSize = 3;
        //then
        assertThat(size).isEqualTo(expectSize);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("테스트 대상은 '1','2','3'값을 가지고 있어야 한다.")
    public void SutNumbers_Should_Have_Ints(int number) throws Exception{
        assertThat(sutNumbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("테스트 대상은 값별로 응답값이 달라야 한다.")
    public void SutNumbers_Should_Be_Different_Each_Number(int number, boolean expected) throws Exception{
        assertThat(sutNumbers.contains(number)).isEqualTo(expected);
    }
}
