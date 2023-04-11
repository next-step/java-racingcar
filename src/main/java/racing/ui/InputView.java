package racing.ui;

import java.util.Scanner;

public class InputView {
    public int car_count;
    public int try_count;

    public InputView(int input_car_count, int input_try_count) {
        this.car_count = input_car_count;
        this.try_count = input_try_count;
    }

    public static InputView create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int input_car_count = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int input_try_count = scanner.nextInt();
        return new InputView(input_car_count,input_try_count);
    }

}
