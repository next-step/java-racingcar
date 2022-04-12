package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static List<Integer> Input(){
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = new ArrayList<>();

        System.out.println("자동차 대수는 몇 대 인가요?");
        inputList.add(scanner.nextInt());

        System.out.println("시도할 회수는 몇 회 인가요?");
        inputList.add(scanner.nextInt());

        return inputList;
    }
}
