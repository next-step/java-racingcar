package racingcar;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class CarRacing {
    static final int GO_CONDITION = 4;
    static final int GO_CONDITION_START_INDEX = 0;
    static final int GO_CONDITION_END_INDEX = 9;

    static void Racing() {
        List<Character>[] cars = new List[CarCount()];
        int tryCount = MoveCount();
        while (tryCount > 0) {
            MoveCar(cars);
            tryCount--;
            System.out.println();
        }
    }

    private static int Count() {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        if (cnt <= 0) throw new IllegalArgumentException("잘못된 입력값 입니다");
        return cnt;
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
            if (StopOrGo()) car.add('-');
            CarLocation(car);
        }
    }

    private static boolean StopOrGo() {
        return ThreadLocalRandom.current().nextInt(GO_CONDITION_START_INDEX, GO_CONDITION_END_INDEX) >= GO_CONDITION;
    }

    private static void CarLocation(List<Character> Car) {
        for (Character c : Car) {
            System.out.print(c);
        }
    }
}
