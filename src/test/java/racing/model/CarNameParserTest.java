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

    @DisplayName("자동차 이름 중복예외 테스트")
    @Test
    void valid() {
        //given
        String participationList = "LG,LG,SKT";
        CarNameParser carNameParser = new CarNameParser(participationList);

        //when
        assertThatThrownBy(carNameParser::parse).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("중복된 자동차 이름이 있습니다.");


    }
}