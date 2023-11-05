package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarGameTest {


    @Test
    @DisplayName("입력 값이 공백, null 일때 Exception 발생")
    public void checkValue_null_또는_빈문자() {
        int result = RacingCarGame.checkValue(null);
        assertThat(result).isEqualTo(0);

        result = RacingCarGame.checkValue("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("입력된 문자 숫자 변환 안될경우 Exception 발생")
    public void checkValue_숫자(){

        assertThatThrownBy(()->RacingCarGame.checkValue("xxxx"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("소수점 포함 여부 판단")
    public void checkValue_정수숫자(){

        assertThatThrownBy(()->RacingCarGame.checkValue("12.3"))
                .isInstanceOf(RuntimeException.class);

    }

    @Test
    @DisplayName("random 함수로 0~9 사이 숫자 생성")
    void randomValue_램덤숫자_생성_테스트() {

        double value = RacingCarGame.randomValue();
        assertAll(
                "random value",
                () -> assertTrue(value > 0, "value is greater the 0"),
                () -> assertTrue(value > 0, "value is small the 9")
        );
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


    @Test
    @DisplayName("입력한 숫자 만큼 Random 숫자 생성")
    void random_반복횟() {

        Map<Integer, Double> randomList = new HashMap<Integer, Double>();

        randomList = RacingCarGame.creatRandom(4);

        assertThat(randomList.size()).isEqualTo(4);

    }

    @Test
    @DisplayName("입력한 숫자 만큼 car 생성, Racing 입력한 숫자 만큼 진행")
    void racingCar_숫자만큼생성() {

        Map<String,RacingCar> carList = new HashMap<String,RacingCar>();

        carList = RacingCarGame.creatCar("3","4");

        assertThat(carList.size()).isEqualTo(3);

    }

}
