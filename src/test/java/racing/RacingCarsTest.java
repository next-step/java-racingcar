package racing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RacingCarsTest {
    @Test(expected = UnsupportedOperationException.class)
    public void 레이싱카_외부에서_변경_못하게_설정() {
        //given
        List<RacingCar> racingCars = new ArrayList<>();
        racingCars.add(new RacingCar());

        //when
        RacingCars resultRacingCars = new RacingCars(racingCars);

        //then
        resultRacingCars.add(new RacingCar());
    }
}