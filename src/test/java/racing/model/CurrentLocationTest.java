package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CurrentLocationTest {

    static final int MINUS_VALUE = -1;

    private static final int NOT_START = 0;
    private static final int ONE_GO_STRAIGHT = 1;

    static final

    @Test
    @DisplayName("시작점을 생성할 때 음수를 입력할 경우 에러를 발생한다.")
    void constructorTestMinus() {
        assertThatThrownBy(() -> new CurrentLocation(MINUS_VALUE)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("전진을 할 때 1칸 앞으로 가는지 판단한다.")
    void goStraightTest() {
        CurrentLocation currentLocation = new CurrentLocation(NOT_START);
        currentLocation.goStraight();
        assertThat(currentLocation.getCurrentLocation()).isEqualTo(ONE_GO_STRAIGHT);
    }

    @Test
    @DisplayName("똑같은 위치에 있을 때 똑같다고 판단하는지에 대한 테스트")
    void isSameLocationTest(){
        CurrentLocation oneLocation = new CurrentLocation(ONE_GO_STRAIGHT);
        CurrentLocation oneLocation2 = new CurrentLocation(ONE_GO_STRAIGHT);
        assertThat(oneLocation.isSameCurrentLocation(oneLocation2)).isEqualTo(true);
    }


}