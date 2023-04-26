package study;

import java.util.Random;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    private RacingCar racingCar = new RacingCar();

    private Scanner scanner = new Scanner(System.in);


    @Test
    void 주어진횟수동안_n대의자동차는_전진또는멈출수있다() {

//      int carCount = racingCar.makeRacingCar(scanner);
    }

    @Test
    void 사용자는몇대의자동차로몇번의이동을할것인지를입력할수있다() {
        int movieCount = 2;
        int carCount =3;
//        racingCar.race(carCount, movieCount);
    }

    @Test
    void 전진하는조건은0에서9사이에서random값을구한후_random값이4이상일경우이다() {

    }

    @Test
    void 자동차의상태를화면에출력한다() {
        Random random = new Random();
        for (int i = 0; i <99 ; i++) {

            System.out.println("random.nextInt(9) = " + random.nextInt(10));
        }
    }

}
