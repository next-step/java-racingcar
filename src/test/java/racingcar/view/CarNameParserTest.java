package racingcar.view;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNameParserTest {

    private String carName1 = "pobi";
    private String carName2 = "crong";
    private String carName3 = "honux";

    @Test
    public void 콤마_단위로_나누기() {
        // given
        String carNamesString =
                Arrays.asList(carName1, carName2, carName3).stream().collect(Collectors.joining(", "));

        // when
        List<String> carNames = CarNameParser.parseCommaCarNamesString(carNamesString);

        // then
        assertThat(carNames).containsExactly(carName1, carName2, carName3);
    }

    @Test
    public void 띄어쓰기_단위로_나누기() {
        // given
        String carNamesString =
                Arrays.asList(carName1, carName2, carName3).stream().collect(Collectors.joining(" "));

        // when
        List<String> carNames = CarNameParser.parseWhiteSpaceCarNamesString(carNamesString);

        // then
        assertThat(carNames).containsExactly(carName1, carName2, carName3);
    }
}
