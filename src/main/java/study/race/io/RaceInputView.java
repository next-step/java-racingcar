package study.race.io;

import java.util.Scanner;

public class RaceInputView {
    
    private int entryNum;
    private int raceNum;

    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        this.entryNum = scanner.nextInt();
    
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.raceNum = scanner.nextInt();

        scanner.close();
    }

    public int getEntryNum() {
        return this.entryNum;
    }

    public int getRaceNum() {
        return this.raceNum;
    }

}
