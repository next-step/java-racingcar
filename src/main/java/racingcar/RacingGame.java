package racingcar;

import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    private int numOfCars;
    private int racingTracks;

    private void racingGame() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("자동차 대수는 몇 대 인가요?");
        numOfCars = sc.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        racingTracks = sc.nextInt();
        String resultElement[] = new String[numOfCars];
        for(int i =0; i<numOfCars; i++) {
            resultElement[i] = "";
        }
        racingResult(rand, numOfCars, racingTracks, resultElement);
    }

    private void racingResult(Random rand, int numOfCars, int racingTracks, String[] resultElement) {
        for(int i=0; i<racingTracks; i++) {
            for(int j=0; j<numOfCars; j++) {
                int result = rand.nextInt(10);
                if(result >= 4) {
                    resultElement[j] += "-";
                }
                System.out.println(resultElement[j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RacingGame rg = new RacingGame();
        rg.racingGame();
    }
}
