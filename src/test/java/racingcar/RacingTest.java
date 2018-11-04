package racingcar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @Test
    public void move_동작_테스트_움직임_조건_4미만인_경우_정지() {
        RacingCar car = new RacingCar(0, "jihan");

        int result = car.move(3);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void move_동작_테스트_움직임_조건_4이상인_경우_이동() {
        RacingCar car = new RacingCar(0, "jihan");

        int result = car.move(4);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 랜덤_숫자_생성() {
        int random = Racing.generateRandomNum();
        assertThat(random).isBetween(0, 9);
    }

    @Test
    public void 가장_먼_위치_찾기() {
        List<Integer> positions = new ArrayList<>();
        positions.add(1);
        positions.add(2);
        positions.add(3);

        Racing racing = new Racing("jihan,pobi,jihan2", 5);

        int result = racing.findMaxPosition(positions);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 같은_위치인지_테스트() {
        RacingCar car = new RacingCar(0,"jihan");

        boolean result = car.isSamePosition(0);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void 우승자_이름_제대로_나오는지_테스트(){
        Racing racing = new Racing("jihan,pobi,jihan2", 5);

        racing.getRacingCars().get(0).move(4);

        String result = racing.winner();
        assertThat(result).isEqualTo("jihan");
    }
}