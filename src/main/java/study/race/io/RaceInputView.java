package study.race.io;

import java.util.Scanner;

public class RaceInputView {
    
    private String delimiter = ",";

    private String[] entryNames;
    private int raceNum;

    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        this.entryNames = scanner.nextLine().split(delimiter);
    
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.raceNum = scanner.nextInt();

        scanner.close();
    }

    public String[] getEntryNames() {
        return this.entryNames;
    }

    public int getRaceNum() {
        return this.raceNum;
    }

}
