package racing.ui;

import java.util.Scanner;

public class InputView {
    public String car_names;
    public int try_count;

    private static final Scanner scanner = new Scanner(System.in);

    public InputView(String input_car_names, int input_try_count) {
        this.car_names = input_car_names;
        this.try_count = input_try_count;
    }

    public static InputView create() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input_car_names = scanner.next();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int input_try_count = scanner.nextInt();
        return new InputView(input_car_names,input_try_count);
    }



}
