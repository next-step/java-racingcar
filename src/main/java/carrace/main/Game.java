package carrace.main;

import carrace.race.Race;
import carrace.utils.InputValidator;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNamesInput = scanner.nextLine();
        String[] carNames = InputValidator.receiveCarNames(carNamesInput);

        System.out.println("시도할 회수는 몇 회 인가요?");
        int numTryInput = scanner.nextInt();
        int numTry = InputValidator.receiveNumTry(numTryInput);

        Race race = new Race(carNames, numTry);
        race.start();

        scanner.close();
    }
}
