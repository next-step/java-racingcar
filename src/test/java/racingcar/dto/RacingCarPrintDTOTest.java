package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

import static org.assertj.core.api.BDDAssertions.then;

class RacingCarPrintDTOTest {

    @Test
    void fromRacingCars() {
        RacingCar racingCar1 = new RacingCar("test1", 0);
        RacingCar racingCar2 = new RacingCar("test2", 1);
        RacingCar racingCar3 = new RacingCar("test3", 2);
        RacingCars racingCars = new RacingCars(List.of(racingCar1, racingCar2, racingCar3));

        List<RacingCarPrintDTO> racingCarPrintDTOS = new ArrayList<>();
        racingCarPrintDTOS.add(new RacingCarPrintDTO(racingCar1));
        racingCarPrintDTOS.add(new RacingCarPrintDTO(racingCar2));
        racingCarPrintDTOS.add(new RacingCarPrintDTO(racingCar3));

        then(RacingCarPrintDTO.fromRacingCars(racingCars)).isEqualTo(racingCarPrintDTOS);
    }
}