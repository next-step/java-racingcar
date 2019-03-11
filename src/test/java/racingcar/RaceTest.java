package racingcar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    private String inputThreeCarName = "가,나,다 ";



    @Test
    public void 자동차대수_셋업() {
        Race race = new Race(inputThreeCarName);
        assertThat(race.getCars().size()).isEqualTo(3);
    }


    @Test
    public void canMove가_true_일때_모든_자동차들이_이동한다() {
        boolean canMove = true;
        Race race = new Race(inputThreeCarName) {
            @Override
            public void run() {
                for (Car car : getCars()) {
                    if (canMove) {
                        car.moveCar();
                    }
                }
            }
        };
        race.run();
        race.run();
        race.run();
        assertThat(race.getCars().size()).isEqualTo(3);
        assertThat(race.getCars().get(0).getMovingDistance()).isEqualTo(3);
        assertThat(race.getCars().get(1).getMovingDistance()).isEqualTo(3);
        assertThat(race.getCars().get(2).getMovingDistance()).isEqualTo(3);
    }


    @Test
    public void canMove가_false_일때_모든_자동차들이_이동하지않는다() {
        boolean canMove = false;
        Race race = new Race(inputThreeCarName) {
            @Override
            public void run() {
                for (Car car : getCars()) {
                    if (canMove) {
                        car.moveCar();
                    }
                }
            }
        };
        race.run();
        race.run();
        race.run();
        assertThat(race.getCars().size()).isEqualTo(3);
        assertThat(race.getCars().get(0).getMovingDistance()).isEqualTo(0);
        assertThat(race.getCars().get(1).getMovingDistance()).isEqualTo(0);
        assertThat(race.getCars().get(2).getMovingDistance()).isEqualTo(0);
    }

}