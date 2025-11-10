package step3;

import java.util.Scanner;

public class InputView {

    public void inputView(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        this.car = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        this.drive = scanner.nextInt();
    }

    private int car;
    private int drive;

    public int getCar() {
        return car;
    }
    public int getDrive() {
        return drive;
    }
}
