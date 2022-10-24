package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    private static int MAX_NUM = 10;
    @Test
    @DisplayName("Car List 초기화")
    public void init_car_list_test() {
        String[] ARR = RacingCar.initCarList(3);
        String initArr[] = new String[]{"", "", ""};
        assertThat(ARR).isEqualTo(initArr);
    }

    @Test
    @DisplayName("Random Num 테스트")
    public void random_num_test() {
        int num = RacingCar.getRandomNum(MAX_NUM);
        assertThat(num).isBetween(0,9);
    }

    @Test
    @DisplayName("이동 테스트")
    public void racing_test() {
        String[] ARR = RacingCar.initCarList(3);
        int num = RacingCar.getRandomNum(MAX_NUM);
        RacingCar.move(0, num);
        if(num >= 4){
            assertThat(ARR[0]).isEqualTo("-");
        }
        else{
            assertThat(ARR[0]).isEqualTo("");
        }
    }
}
