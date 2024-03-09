package racingcar;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class CarRacing {
    static final int GO_CONDITION = 4;
    static final int GO_CONDITION_START_INDEX = 0;
    static final int GO_CONDITION_END_INDEX = 9;
    static List[] cars;

    static void Racing() {
        makeCars(CarCount(count()));
        int tryCount = MoveCount(count());
        while (tryCount > 0) {
            MoveCar(cars);
            tryCount--;
            System.out.println();
        }
    }

    static int count() {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        if (cnt <= 0) throw new IllegalArgumentException("잘못된 입력값 입니다");
        return cnt;
    }

    static int CarCount(int input) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return input;
    }

    static void makeCars(int input) {
        cars = new List[input];
        for (int i = 0; i < input; i++) {
            cars[i] = new LinkedList<>();
        }
    }

    static int MoveCount(int input) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return input;
    }

    static void MoveCar(List<Character>[] cars) {
        for (List<Character> car : cars) {
            if (StopOrGo(GO_CONDITION_START_INDEX, GO_CONDITION_END_INDEX, GO_CONDITION)) car.add('-');
            CarLocation(car);
        }
    }

    static boolean StopOrGo(int start, int end, int condition) {
        return ThreadLocalRandom.current().nextInt(start, end) >= condition;
    }

    static void CarLocation(List<Character> Car) {
        for (Character c : Car) {
            System.out.print(c);
        }
    }
}
