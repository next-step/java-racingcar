package racingcar;

import java.util.List;
import java.util.Scanner;

public class CarRacing {

    static void Racing() {
        List<String>[] cars = new List[CarCount()];

    }
    static int CarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner cnt = new Scanner(System.in);
        return cnt.nextInt();
    }
}
