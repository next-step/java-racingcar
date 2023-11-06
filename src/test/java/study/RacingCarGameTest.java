package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarGameTest {


    @Test
    @DisplayName("4대의 차량이 3번 래이싱 테스트")
    void creatCar_차량생성() {

        Map<String,RacingCar> carsMap = RacingCarGame.creatCar("4","3");
        assertThat(carsMap.size()).isEqualTo(4);
        assertThat(carsMap.get("CarNo0").getLoopCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("반복 횟수 만큰 생성한 Random 숫자 중 4보다 큰 값 Count")
    void count_4보다큰값() {

        Map<Integer, Double> randomList = new HashMap<Integer, Double>();

        randomList.put(0, 1.2);
        randomList.put(1, 5.1);
        randomList.put(2, 8.4);

        int result = RacingCarGame.countDrive(randomList);
        assertThat(result).isEqualTo(2);

    }


}
