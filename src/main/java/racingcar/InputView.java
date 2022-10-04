package racingcar;

import java.util.Scanner;

public class InputView {
    private static final Scanner  scanner = new Scanner(System.in);

    private InputView() {
        throw new RuntimeException("인스턴스화가 불가능한 클래스입니다.");
    }

    public static String getNameListOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String nameListOfCars = scanner.nextLine();
        return nameListOfCars;
    }

    public static int getTryingCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int count = scanner.nextInt();

        if(count < 0 || count > 100) {
            throw new RuntimeException("1에서 99까지의 숫자만 입력해주세요.");
        }

        return count;
    }


}
