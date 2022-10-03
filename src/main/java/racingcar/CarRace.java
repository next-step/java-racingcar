package racingcar;

import java.util.Scanner;

public class Rc {

    public static void main(String[] args) {

        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        String joinedCar = scanner.nextLine();
        new Rc().joinRace(joinedCar);

        System.out.println("시도할 회수는 몇 회 인가요?");
        String raceCnt = scanner.nextLine();
        new Rc().startRace(raceCnt);
    }

    public int joinRace(String joinedCar) {
        return Integer.parseInt(joinedCar);
    }

    public int startRace(String value) {
        return Integer.parseInt(value);
    }
}
