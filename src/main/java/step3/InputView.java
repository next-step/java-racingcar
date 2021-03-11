package step3;

import java.util.Scanner;

public class InputView {

    private int cars;
    private int challenges;

    public void inputValues() {
        Scanner scan = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대인가요?");
        this.cars = scan.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        this.challenges = scan.nextInt();
    }

    public int getCars() {
        return cars;
    }

    public int getChallenges() {
        return challenges;
    }
}
