package step3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    void 여러대의_차를_모두_같은_전략으로_이동시킨다() {
        MovingStrategy movingStrategy = () -> true;
        Cars cars = new Cars(5, movingStrategy);

        cars.moveAll();

        // 어떻게 차들의 상태를 테스트하지?
    }
}