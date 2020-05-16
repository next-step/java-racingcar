package step3.view;

import java.util.Scanner;

public class InputView {

    private int numberOfCars;
    private int moveCount;

    public void input(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        numberOfCars = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        moveCount = scanner.nextInt();
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
