package racing;

import java.util.Scanner;

public class InputView {
    private static final String HOW_MANY_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String HOW_MANY_TIMES = "시도할 회수는 몇 회 인가요?";

    public void input() {
        Input input = new Input();
        Scanner scanner = new Scanner(System.in);

        System.out.println(HOW_MANY_CARS);
        input.inputCarsQuantity(scanner.nextInt());

        System.out.println(HOW_MANY_TIMES);
        input.inputTimes(scanner.nextInt());
    }



}
