import java.util.Scanner;

public class InputReview {

    private int cars;
    private int attempts;
    private static final Scanner scanner = new Scanner(System.in);

    public InputReview() {
    }

    public InputReview(int cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public void inputCarNumber() {

        System.out.println("자동차 대수는 몇 대 인가요?");
        try {
            this.cars = scanner.nextInt();
        } catch (Exception e) {
            throw new NotNumberException("숫자만 입력하세요!");
        }
        if (this.cars < 0) throw new NotPositiveNumberException("양수만 입력하세요");
    }

    public void inputAttemptNumber() {

        System.out.println("시도할 회수는 몇 회 인가요?");
        try {
            this.attempts = scanner.nextInt();
        } catch (Exception e) {
            throw new NotNumberException("숫자만 입력하세요!");
        }
        if (this.attempts < 0) throw new NotPositiveNumberException("양수만 입력하세요");
    }

    public int getCars() {
        return cars;
    }

    public int getAttempts() {
        return attempts;
    }
}
