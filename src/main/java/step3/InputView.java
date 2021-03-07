package step3;

import java.util.Scanner;

public class InputView {

    private int carCount;
    private int tryCount;

    public void inputView(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();
    }

    public int getCarCount() {
        return carCount;
    }

    public int getTryCount() {
        return tryCount;
    }
}
