package step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static step4.CarFactory.*;

public class InputView {

    public static final String CAR_NUM_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String TRY_NUM_TEXT = "시도할 회수는 몇 회 인가요?";

    public static final Scanner scanner = new Scanner(System.in);

    public static List<Car> inputCarName() {
        System.out.println(CAR_NUM_TEXT);
        return produceCar(scanner.next());
    }

    public static int inputTryNum() {
        System.out.println(TRY_NUM_TEXT);
        return scanner.nextInt();
    }
}
