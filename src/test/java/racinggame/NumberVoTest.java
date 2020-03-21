package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberVoTest {

    @DisplayName("0~9 사이의 정수값 반환 하는지 테스트")
    @Test
    public void createRandomNumber() throws Exception {
        //given
        int i = 0;

        //then
        while (i < 100) {
            assertThat(NumberVo.createRandomNumber()).isBetween(0, 9);
            i++;
        }
    }

    @DisplayName("값이 4 이상이면 true")
    @ParameterizedTest
    @CsvSource(value = {"-1:false", "0:false", "2:false", "4:true", "6:true", "10:true"}, delimiter = ':')
    public void isGreaterThan4(int num, boolean expect) throws Exception {
        //given
        NumberVo vo = new NumberVo(num);

        //then
        assertThat(vo.isGreaterThan4()).isEqualTo(expect);
    }


}