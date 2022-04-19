package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    List<Integer> inputList = new ArrayList<>();

    public InputView() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        this.inputList.add(scanner.nextInt());

        System.out.println("시도할 회수는 몇 회 인가요?");
        this.inputList.add(scanner.nextInt());

    }
}
