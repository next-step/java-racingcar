package step03;

import java.util.Map;
import java.util.Scanner;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:41 오후
 */
public class RacingCarMain {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        int numberOfCars = 0;
        int numberOfAttempts = 0;

        System.out.println("자동차의 대수는 몇 대 인가요?");
        numberOfCars = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        numberOfAttempts = scanner.nextInt();

        final Racing racing = new Racing();
        System.out.println("실행결과");
        racing.race(numberOfCars, numberOfAttempts);

    }

}
