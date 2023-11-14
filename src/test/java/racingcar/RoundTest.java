package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.utils.NumberGenerator;

public class RoundTest {

    @Test
    @DisplayName("Round별 이동된 자동차 저장 확인")
    void roundRecordTest() {
        List<Car> carList = Arrays.asList(new Car("Car1"), new Car("Car2"), new Car("Car3"));
        Cars cars = new Cars(carList);
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(4);
        Round round = cars.moveForwardCars(fixedNumberGenerator);
        List<Car> recordedCars = round.getRoundCarStatus().getCars();

        for (int i = 0; i < carList.size(); i++) {
            assertThat(recordedCars.get(i).getCarPosition().getPosition()).isEqualTo(1);
        }
    }

    class FixedNumberGenerator implements NumberGenerator {

        private final int fixedNumber;

        public FixedNumberGenerator(int fixedNumber) {
            this.fixedNumber = fixedNumber;
        }

        @Override
        public int generateNumber() {
            return fixedNumber;
        }
    }

}
