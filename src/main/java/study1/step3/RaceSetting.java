package study1.step3;

import java.util.Scanner;

public class RaceSetting {
    private Scanner scanner;
    RaceSetting(){
        this.scanner = new Scanner(System.in);
    }

    int getCarCnt(){
        System.out.println("자동차 대수는 몇 대 인가요?");
        return this.scanner.nextInt();
    }

    int getRaceCnt(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        return this.scanner.nextInt();
    }

    void close(){
        this.scanner.close();
    }
}
