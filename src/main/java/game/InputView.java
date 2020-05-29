package game;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this(new Scanner(System.in));
    }

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Scanner getScanner() {
        return scanner;
    }

    /**
     * 압력 항목 요구 메시지 화면 출력
     *
     * @param message
     */
    public void viewMessage(String message) {
        System.out.println(message);
    }

    /**
     * 경주 참여 자동차 수 입력 기능
     *
     * @return
     */
    public int getNumberOfCars() {
        viewMessage("자동차 대수는 몇 대 인가요?");
        return getInputInteger();
    }

    /**
     * 경주 횟수 입력 기능
     *
     * @return
     */
    public int getRacingCount() {
        viewMessage("시도할 회수는 몇 회 인가요?");
        return getInputInteger();
    }

    /**
     * 숫자를 입력 받는 기능
     *
     * @return
     */
    private int getInputInteger() {

        int input = scanner.nextInt();

        if (input <= 0) {
            throw new IllegalArgumentException("0 보다 큰 수를 입력 하세요.");
        }

        return input;
    }


    public static InputView create() {
        return new InputView();
    }
}
