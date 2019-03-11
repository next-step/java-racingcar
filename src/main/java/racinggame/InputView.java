package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static List<Integer> getInput() {
        List<Integer> inputs = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        inputs.add(sc.nextInt());
        sc.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        inputs.add(sc.nextInt());
        sc.nextLine();

        return inputs;
    }

}