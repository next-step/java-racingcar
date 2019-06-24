package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private String carNameString = "pobi,crong,honux";
    private Cars cars;

    @BeforeEach
    void setUp() {
        CarNames carNames = new CarNames(carNameString);
        cars = new Cars(carNames);
    }

    @Test
    void 생성자_정상() {
        assertThat(cars.getPositions()).containsKeys("pobi", "crong", "honux");
        assertThat(cars.getPositions()).containsValues(1, 1, 1);
    }

    @Test
    void 모든_자동차가_이동한다() {
        MoveDecider moveDecider = new MoveDecider() {
            @Override
            public boolean canMove() {
                return true;
            }
        };
        cars = cars.moveCarsByDecider(moveDecider);
        assertThat(cars.getPositions()).containsKeys("pobi", "crong", "honux");
        assertThat(cars.getPositions()).containsValues(2, 2, 2);
    }
}
