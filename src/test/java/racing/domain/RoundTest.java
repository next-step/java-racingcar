package racing.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racing.vo.CarResultVO;

class RoundTest {

    @Test
    void 라운드에서_1만큼_이동_후_결과를_저장한다() {
        Round round = new Round(2);
        MoveRule goMoveRule = new MoveRule() {
            @Override
            public int makeValue() {
                return 1;
            }

            @Override
            public boolean isMovable() {
                return true;
            }
        };

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("a", goMoveRule));
        cars.add(new Car("b", goMoveRule));

        List<CarResultVO> result = round.play(cars);

        for(int i = 0; i < result.size(); i++) {
            assertThat(result.get(i).getDistance()).isEqualTo(1);
            assertThat(result.get(i).getName()).isEqualTo(cars.get(i).getName());
        }
    }
}
