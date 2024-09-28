import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);
    private int carCount;
    private int moveCount;


    public int getCarCount() {
        return this.carCount;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public void receiveCarCount() {
        System.out.println("자동차 대수는 몇 대인가요?");

        while (true) {
            try {
                int carCount = scanner.nextInt();

                if (carCount <= 1) {
                    throw new NumberFormatException("2 ~ 9 사이의 양수를 입력해주세요.");
                }

                this.carCount = carCount;
                break;
            } catch (NumberFormatException e) {
                System.out.println("2 ~ 9 사이의 유효한 숫자를 입력 해주세요.");
            }
        }
        System.out.println(this.carCount);
    }

    public void receiveMoveCount() {
        System.out.println("시도할 회수는 몇 회인가요?");

        while (true) {
            try {
                int moveCount = scanner.nextInt();


                if (moveCount <= 1) {
                    throw new NumberFormatException("1 ~ 9 사이의 양수를 입력해주세요.");
                }

                this.moveCount = moveCount;
                break;
            } catch (NumberFormatException e) {
                System.out.println("1 ~ 9 사이의 유효한 숫자를 입력 해주세요.");
            }
        }
        System.out.println(this.moveCount);
    }

    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
