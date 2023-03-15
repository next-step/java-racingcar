package racingCar;

import CarRacing.CarRace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {


    @DisplayName("자동차 이름 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "pobi,woni, jun" })
    void getCarNamesTest(String input) {
        assertThat(CarRace.getCarObjects(input)).isEqualTo(List.of("pobi", "woni", "jun"));
    }

    @DisplayName("자동차이름 길이 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "pobi,woni,jun" })

    void getWinnerTest(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        assertThat(CarRace.checkCarName(carNames)).isTrue();
    }


}
