package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarNameParserTest {

    @DisplayName("자동차 이름 분할 테스트")
    @Test
    void parse() {
        //given
        String participationList = "LG,KT,SKT";
        CarNameParser carNameParser = new CarNameParser(participationList);

        //when 
        String[] racingCarNames = carNameParser.parse();

        //then
        assertThat(racingCarNames[0]).isEqualTo("LG");
        assertThat(racingCarNames[1]).isEqualTo("KT");
        assertThat(racingCarNames[2]).isEqualTo("SKT");
    }
}