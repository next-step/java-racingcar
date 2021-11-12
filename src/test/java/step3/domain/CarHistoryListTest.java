package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarHistoryListTest {

    @DisplayName("특정 round에서의 car 위치를 반환한다.")
    @Test
    void getPosition() {
        CarHistoryList carHistoryList = new CarHistoryList();
        carHistoryList.add(CarOperation.GO, 1);
        assertThat(carHistoryList.getPosition(0)).isEqualTo(1);
    }

    @DisplayName("가장 마지막으로 이동한 Car위치를 반환한다.")
    @Test
    void getLastPosition(){
        CarHistoryList carHistoryList = new CarHistoryList();
        carHistoryList.add(CarOperation.GO, 1);
        carHistoryList.add(CarOperation.STOP, 1);
        assertThat(carHistoryList.getLastPosition()).isEqualTo(1);
    }

}