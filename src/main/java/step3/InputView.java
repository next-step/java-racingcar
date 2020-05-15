package step3;

import static java.lang.System.exit;

import java.util.Scanner;

public class InputView {

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

    public int enterCarCount() {
        printCarCountRequest();
        int count = this.scanner.nextInt();
        if (false == validateCarCount(count)) {
            System.out.println("invalid count (between 2 and 9)");
            exit(0);
        }
        return count;
    }

    public int enterTime() {
        printTimeRequest();
        int time = this.scanner.nextInt();
        if (false == validateTime(time)) {
            System.out.println("invalid time (between 2 and 9)");
            exit(0);
        }
        return time;
    }
}
