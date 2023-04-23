package racing.view;

import java.util.Scanner;

public class InputView {
    private static InputView instance;

    private InputView() {}

    private static final Scanner SCANNER = new Scanner(System.in);

    private static class InputViewInstanceHolder {
        private static final InputView INSTANCE = new InputView();
    }
    public static InputView getInstance(){
        return InputViewInstanceHolder.INSTANCE;
    }

    public static int inputCarCount() {
        System.out.println("자동차 대수는 몇대인가요?");
        return inputCount();
    }

    public static int inputTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return inputCount();
    }

    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        return SCANNER.nextLine();
    }

    public static int inputCount() {
        return SCANNER.nextInt();
    }
}