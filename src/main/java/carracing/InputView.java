package carracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class InputView {
    public static List<Integer> inputView() {
        List<Integer> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryNumber = scanner.nextInt();

        result.add(carNumber);
        result.add(tryNumber);

        return result;
    }

}
