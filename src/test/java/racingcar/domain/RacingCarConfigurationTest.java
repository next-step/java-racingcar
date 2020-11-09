package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.utils.Number;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarConfigurationTest {

    @Test
    @DisplayName("RacingCarConfiguration 생성자 테스트")
    public void new_racingCarConfiguration() {

        RacingCarConfiguration racingCarConfiguration = new RacingCarConfiguration();
        List<Car> racingCars = racingCarConfiguration.enterCar("car,bus");

        assertThat(racingCars.size()).isEqualTo(2);

        assertThat(racingCars.get(0)).isNotNull();
        assertThat(racingCars.get(0).getName()).isEqualTo("car");

        assertThat(racingCars.get(1)).isNotNull();
        assertThat(racingCars.get(1).getName()).isEqualTo("bus");

    }

    @Test
    @DisplayName("우승한 자동차 이름들을 ,로 구분하는 메소드 테스트")
    public void isSplit_ShouldReturnNamesWithRest() {
        List<String> names = new ArrayList<>();
        names.add("bus");
        names.add("car");
        names.add("test");
        names.add("bug");

        StringBuilder sb = new StringBuilder();
        int listSize = names.size();

        sb.append(names.get(Number.ZERO));
        for (int index =1; index < listSize; index++) {
            sb.append(',').append(names.get(index));
        }

        String result = sb.toString();
        assertThat(result).isEqualTo("bus,car,test,bug");
    }
}
