package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.controller.dto.OutputDTO;

public class VictoryTest {

    private static final String COMMAS = ",";

    @DisplayName("우승자_확인_테스트")
    @ParameterizedTest
    @CsvSource({"a,aa,aaa"})
    public void maxCheckTest(String one, String two, String three) {
        //given
        final Cars cars = new Cars(Arrays.asList(one, two, three));

        //when
        cars.cars().get(0).moveForward();
        cars.cars().get(0).moveForward();
        cars.cars().get(0).moveForward();

        Victory victory = Victory.makeVictoryCars(cars);
        List<OutputDTO> victoryResult = victory.victory()
            .stream()
            .map(OutputDTO::new)
            .collect(Collectors.toList());
        //then
        assertThat(victoryResult.stream().map(OutputDTO::getCarName)
            .collect(Collectors.joining(COMMAS))).isEqualTo("a");
    }
}
