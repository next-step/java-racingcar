package step5.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String NUMBER_OF_CAR = "자동차 대수는 몇 대 인가요?";
    private static final String NUMBER_OF_TRY = "시도할 회수는 몇 회 인가요?";
    private static final String NAME_OF_CARS = "자동차의 이름을 입력해주세요?";


    public static int inputCarCount() {
        System.out.println(NUMBER_OF_CAR);
        return scanner.nextInt();
    }


    public static int inputTryCount() {
        System.out.println(NUMBER_OF_TRY);
        return scanner.nextInt();
    }


    public static String inputCarNames() {
        System.out.println(NAME_OF_CARS);
        return scanner.next();
    }
}
