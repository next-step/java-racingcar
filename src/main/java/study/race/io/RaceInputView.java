package study.race.io;

import java.util.Scanner;

public class RaceInputView {
    
    private int carNum;
    private int tryNum;

    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        carNum = scanner.nextInt();
    
        System.out.println("시도할 회수는 몇 회 인가요?");
        tryNum = scanner.nextInt();

        scanner.close();
    }

    public int getCarNum() {
        return carNum;
    }

    public int getTryNum() {
        return tryNum;
    }

}
