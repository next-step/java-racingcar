package racing.ui;

import java.util.Scanner;

public class InputView {

    public static Form createForm() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner carScanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner playScanner = new Scanner(System.in);
        return new Form(carScanner.nextInt(), playScanner.nextInt());
    }
}
