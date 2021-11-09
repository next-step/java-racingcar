package racing.view;

import java.util.Scanner;

public class CliInputView {

    private CliInputView() {}

    public static int getNumberOfCarFromCliInput() {
        System.out.println("자동차 대수는 몇 대인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
