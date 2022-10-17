package fourstep.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String[] inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String str = scanner.next();
        String[] strArr = str.split(",");

        int carNameErrFlag = checkEntireName(strArr);

        if (carNameErrFlag != 0) {
            System.out.println("자동차 이름은 5 글자를 초과할 수 없습니다.");
            scanner = new Scanner(System.in);
            return inputCarName();
        }
        return strArr;
    }

    public static int checkEntireName(String[] strArr) {
        int carNameErrFlag = 0;
        for (String s : strArr) {
            carNameErrFlag += checkName(s);
        }
        return carNameErrFlag;
    }

    public static int checkName(String carName) {
        if (carName.length() > 5) {
            return 1;
        }
        return 0;
    }

    public static int inputRaceCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        try {
            int raceCount = scanner.nextInt();

            if (raceCount <= 0) {
                System.out.println("0이상 값만 입력해 주세요.");
                scanner = new Scanner(System.in);
                return inputRaceCount();
            }

            return raceCount;
        } catch (InputMismatchException e) {
            System.out.println("양의 정수값만 입력해 주세요.");
            scanner = new Scanner(System.in);
            return inputRaceCount();
        }
    }
}

