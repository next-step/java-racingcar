package racing;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racing.Utils.splitCarNames;

public class RacingCarsTest {
    String[] names;
    List<RacingCar> racingCars;
    RacingCars resultRacingCars;

    @Before
    public void setUp() throws Exception {
        names = splitCarNames("m1, m2");
        racingCars = Arrays.asList(
                new RacingCar(names[0], 1)
                , new RacingCar(names[1], 0)
        );
       resultRacingCars = new RacingCars(racingCars);
    }

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

    @Test
    public void 우승자_구하기() {
        //then
        assertThat(resultRacingCars.findWinners()).hasSize(1);
    }

    @Test
    public void 우승자의_좌표가_1일때_우승자인지_확인() {
        //then
        assertThat(racingCars.get(0).isMaxPosition(1)).isTrue();
    }
}