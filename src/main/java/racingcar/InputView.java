package racingcar;

import java.util.Scanner;

public class InputView {

    private int cars;
    private int rounds;

    public int getCars() {
        return cars;
    }

    public int getRounds() {
        return rounds;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차는 몇 대인가요?");
        cars = scanner.nextInt();
        System.out.println("몇 번 시도하나요?");
        rounds = scanner.nextInt();
    }
}
