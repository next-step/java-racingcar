package racingcar;

import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    static final int RANGEOFNUM = 10;
    static final int LIMIT = 4;
    private int numOfCars;
    private int racingTracks;
    public int resultElement[];

    private void racingGame() {
        inputValue();
        resultElement = new int[numOfCars];
        racing();
    }

    private void inputValue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        numOfCars = sc.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        racingTracks = sc.nextInt();
    }

    private void racing() {
        for(int i=0; i<racingTracks; i++) {
            move();
            displayResult();
            System.out.println();
        }
    }

    private void displayResult() {
        for(int i=0; i<numOfCars; i++) {
            String str = "";
            if(resultElement[i] > 0) {
                str = drawLine(resultElement[i]);
            }
            System.out.println(str);
        }
    }

    public static String drawLine(int state) {
        String str = "";
        for(int i=0; i<state; i++) {
            str += "-";
        }
        return str;
    }

    public void move() {
        Random rand = new Random();
        for(int i=0; i<numOfCars; i++) {
            int currentPos = rand.nextInt(RANGEOFNUM);
            int resultData = checkLimit(currentPos);
            resultElement[i] += resultData;
        }
    }

    public int checkLimit(int currentPos) {
        if(currentPos >= LIMIT) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        RacingGame rg = new RacingGame();
        rg.racingGame();
    }
}
