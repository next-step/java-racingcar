package racing;

import calculator.Calculation;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingGame {


    public static void start() {
        Rule rule = new Rule();
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n");
        Scanner nameInput = new Scanner(System.in);
        String[] names = nameInput.next().split(",");
        Car[] cars = new Car[names.length];
        for (int idx = 0; idx <= names.length - 1 && rule.isGame; idx++) {
            cars[idx] = new Car(names[idx]);
            rule.NameLengthCheck(names[idx]);
            System.out.println(cars[idx].getName());
        }

        System.out.println("시도할 횟수는 몇 회인가요?.\n");
        Scanner roundInput = new Scanner(System.in);
        int round = roundInput.nextInt();
        rule.setRound(round);
        System.out.println("실행 결과");

        for (int roundIdx = 0; roundIdx < rule.round && rule.isGame; roundIdx++) {
            rule.checkWinnerReset();
            for (int carsIdx = 0; carsIdx <= cars.length - 1 ; carsIdx++) {
                System.out.print(cars[carsIdx].getName()+":");
                rule.checkWinner(cars[carsIdx].getName(),cars[carsIdx].getSpeed(),roundIdx, carsIdx);
                System.out.println();
            }
            rule.roundWinner(roundIdx);
        }
        rule.finalWinner();
    }
    public static void main(String[] args) {
        start();
    }
}
