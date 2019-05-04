package racing;

import org.junit.Before;
import org.junit.Test;

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
                , new RacingCar(names[1], 1)
        );
        resultRacingCars = new RacingCars(racingCars);
    }

//    @Test(expected = UnsupportedOperationException.class)
//    public void 레이싱카_외부에서_변경_못하게_설정() {
//        //given
//        List<RacingCar> racingCars = new ArrayList<>();
//        racingCars.add(new RacingCar());
//
//        //when
//        RacingCars resultRacingCars = new RacingCars(racingCars);
//
//        //then
//        resultRacingCars.add(new RacingCar());
//    }

    @Test
    public void 차_2대이상_생성_후_움직임() {
        //given
        //when
        List<RacingCar> racingCars2 = resultRacingCars.getObjects();

        //then
        assertThat(racingCars2.get(0).toString()).isEqualTo("-");
    }

    @Test
    public void 우승자_구하기() {
        //then
        assertThat(resultRacingCars.findWinners()).hasSize(2);
    }

    @Test
    public void 우승자의_좌표가_1일때_우승자인지_확인() {
        //then
        assertThat(racingCars.get(0).isMaxPosition(1)).isTrue();
    }

    @Test
    public void 우승자_이름_구하기() {
        assertThat(resultRacingCars.getWinnerName()).contains("m1");
        assertThat(resultRacingCars.getWinnerName()).contains("m2");
    }

    @Test
    public void 무빙랜덤생성() {
        //when
        resultRacingCars.randomMove(3);

        //then
        for (RacingCar racingCar : resultRacingCars.getObjects()) {
            assertThat(racingCar.position).isEqualTo(1);
        }
    }
}