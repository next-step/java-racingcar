package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;
import racing.domain.RaceRule;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarRacingTest {


    @ParameterizedTest
    @ValueSource(strings = {"next,step,yoon"})
    @DisplayName("자동차 경주 테스트")
    void 자동차경주_게임_테스트(String names) {
        // given
        int maxLaps = 3;
        String setRecord1 = "111";
        String setRecord2 = "1,11,11,1";
        String setRecord3 = "1,1,11,1,11,1,1";

        // when
        CarRacingImpl carRacing = new CarRacingImpl(names, maxLaps);
        carRacing.start();

        List<Car> cars = carRacing.getRaceResults().findResult(maxLaps-1);
        StringBuilder resultRecord1 = new StringBuilder();
        StringBuilder resultRecord2 = new StringBuilder();
        StringBuilder resultRecord3 = new StringBuilder();

        for(Car car : cars) {
            resultRecord1.append(car.getRaceSetting().findRecord(0));
            resultRecord2.append(car.getRaceSetting().findRecord(1));
            resultRecord3.append(car.getRaceSetting().findRecord(2));
        }

        // then
        assertAll(
                () -> assertThat(resultRecord1.toString()).contains(setRecord1),
                () -> assertThat(resultRecord2.toString()).contains(setRecord2),
                () -> assertThat(resultRecord3.toString()).contains(setRecord3)
        );
    }

    static class CarRacingImpl extends CarRacing{

        public CarRacingImpl(String carNames, int maxLaps) {
            super(carNames, maxLaps);
        }

        @Override
        public RaceRule raceRule() {
            return () -> true;
        }
    }
}
