import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private int carNumber;
    private int tryCount;

    public InputView() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        carNumber = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        tryCount = scanner.nextInt();
        System.out.println();

        if (carNumber < 1 || tryCount < 1)
            throw new IllegalArgumentException(String.format("입력값은 양수여야 합니다. carNumber:%d, tryCount:%d", carNumber, tryCount));
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getTryCount() {
        return tryCount;
    }
}