package carracing;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public List<String> inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        String[] cars = scanner.nextLine().split(",");
        return Arrays.asList(cars);
    }

    public int intTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
}
