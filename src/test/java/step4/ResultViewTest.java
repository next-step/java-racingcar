package step4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultViewTest {
    static int maxCarPosition = 0;
    static String maxCarName = "";
    @DisplayName("최종 우승 메시지 출력이 잘 나타나는 지 확인")
    @Test
    public void findMaxPositionCarName() {
        int[] carPositions = {1,2,3,4,3,4};
        String[] carNames = {"a","b","c","d","e","f"};

        for (int i = 0; i < carPositions.length; i++) {
            int carPosition = carPositions[i];
            String carName = carNames[i];
            findMaxPositionCarName(carPosition, carName);
        }
        Assertions.assertThat(maxCarName).isEqualTo("d, f");
    }

    private void findMaxPositionCarName(int carPosition, String carName) {
        if (carPosition > maxCarPosition) {
            maxCarName = carName;
            maxCarPosition = carPosition;
            return;
        }
        if (carPosition == maxCarPosition) {
            maxCarName += ", "+ carName;
            return;
        }
    }


}