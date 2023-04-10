package ui;

import java.util.Scanner;

public class InputView {
    public static final int INVAlID_NUMBER = 0;
    private final Scanner scanner = new Scanner(System.in);

    public int carSize = INVAlID_NUMBER;
    public int trySize = INVAlID_NUMBER;

    public void saveInputs() {
        saveCarSize();
        saveTrySize();
    }

    private void saveCarSize() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        carSize = scanner.nextInt();
    }

    private void saveTrySize() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        trySize = scanner.nextInt();
    }
}
