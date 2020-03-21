package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;


public class RacingCarTest {

    @DisplayName("요구사항 프로세스를 확인하기 위해 작성한 첫 테스트.")
    @Test
    void processTest() {
        System.out.println("자동차는 몇 대 인가요");
        int cars = 3;
        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = 3;

        //cars의 수 만큼 carPositions  arrays  생성.
        int[] carPositiins = new int[cars];

        //랜덤값 생성을 위한 객체
        Random randomNum = new Random();
        //time 만큼 시도.
        String VIEW = "-";
        while (time > 0) {
            for (int i = 0; i < carPositiins.length; i++) {
                boolean flag = randomNum.nextInt(10) > -1;
                if (flag) {
                    carPositiins[i]++;
                }
                for (int j = 0; j < carPositiins[i]; j++) {
                    System.out.printf(VIEW);
                }
                System.out.println();
            }
            time--;
            System.out.println();
        }

    }
}
