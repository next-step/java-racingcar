package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarCollectionTest {
    private MoveStrategy moveStrategyTrue = () -> true;
    private MoveStrategy moveStrategyFalse = () -> false;

    @Test
    @DisplayName("모든 자동차는 이동 시 위치가 1 증가한다.")
    void move() {
        CarCollection carCollection = new CarCollection(5, moveStrategyTrue);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1,1,1,1,1));
        assertThat(carCollection.getPositionList()).isEqualTo(expected);
    }

    @Test
    @DisplayName("모든 자동차는 정지 시 위치가 변하지 않는다.")
    void stay() {
        CarCollection carCollection = new CarCollection(5, moveStrategyFalse);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0,0,0,0,0));
        assertThat(carCollection.getPositionList()).isEqualTo(expected);
    }

    @Test
    @DisplayName("지정한 car의 개수를 반환할 수 있다.")
    void size() {
        CarCollection carCollection = new CarCollection(5, new FourOverTenMoveStrategy());
        assertThat(carCollection.size()).isEqualTo(5);
    }
}
