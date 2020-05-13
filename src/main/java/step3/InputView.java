package step3;

import java.util.Scanner;

public class InputView {

    private int carCount;
    private int time;
    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public void printCarCountRequest() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public void printTimeRequest() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public boolean validateCarCount(int carCount) {
        if (carCount < 2 || carCount > 9) {
            return false;
        }
        return true;
    }

    public boolean validateTime(int time) {
        if (time < 2 || time > 9) {
            return false;
        }
        return true;
    }

    public void inputCarCount() {
        printCarCountRequest();
        int count = this.scanner.nextInt();
        if (validateCarCount(count)) {
            this.carCount = count;
        }
    }

    public void inputTime() {
        printTimeRequest();
        int time = this.scanner.nextInt();
        if (validateTime(time)) {
            this.time = time;
        }
    }
}
