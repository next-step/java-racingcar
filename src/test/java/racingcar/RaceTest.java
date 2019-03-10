package racingcar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    @Test
    public void 자동차대수_셋업() {
        Race race = new Race(2);
        assertThat(race.getCarList().size()).isEqualTo(2);
    }


    @Test
    public void canMove가_true_일때_모든_자동차들이_이동한다() {
        boolean canMove = true;
        Race race = new Race(3) {
            @Override
            public void run() {
                for (Car car : getCarList()) {
                    if (canMove) {
                        car.moveCar();
                    }
                }
            }
        };
        race.run();
        race.run();
        race.run();
        assertThat(race.getCarList().get(0).getMovingDistance()).isEqualTo(3);
        assertThat(race.getCarList().get(1).getMovingDistance()).isEqualTo(3);
        assertThat(race.getCarList().get(2).getMovingDistance()).isEqualTo(3);
    }


    @Test
    public void canMove가_false_일때_모든_자동차들이_이동한다() {
        boolean canMove = false;
        Race race = new Race(3) {
            @Override
            public void run() {
                for (Car car : getCarList()) {
                    if (canMove) {
                        car.moveCar();
                    }
                }
            }
        };
        race.run();
        race.run();
        race.run();
        assertThat(race.getCarList().get(0).getMovingDistance()).isEqualTo(0);
        assertThat(race.getCarList().get(1).getMovingDistance()).isEqualTo(0);
        assertThat(race.getCarList().get(2).getMovingDistance()).isEqualTo(0);
    }

}