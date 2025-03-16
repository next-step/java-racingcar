package racingcar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt(); // 첫 번째 값 입력받음

        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfRounds = scanner.nextInt(); // 두 번째 값 입력받음

        System.out.println("\n실행결과");
        Racing racing = new Racing(numberOfCars);
        for (int i = 0; i < numberOfRounds; i++) {
            System.out.println(ResultView.printDistance(racing.playRound()));
            System.out.println();
        }
    }
}
