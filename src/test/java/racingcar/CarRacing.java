package racingcar;

import java.util.List;
import java.util.Scanner;

public class CarRacing {
    static final int GO_CONDITION = 4;
    static final int GO_CONDITION_START_INDEX = 0;
    static final int GO_CONDITION_END_INDEx = 9;

    static void Racing() {
        List<Character>[] cars = new List[CarCount()];
        int tryCount = MoveCount();
    }

    private static int Count() {
        Scanner cnt = new Scanner(System.in);
        return cnt.nextInt();
    }
    private static int CarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return Count();
    }

    private static int MoveCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return Count();
    }

    private static void MoveCar(List<Character>[] cars) {
        for (List<Character> car : cars) {

        }
    }

    private static void StopOrGo() {

    }

}
