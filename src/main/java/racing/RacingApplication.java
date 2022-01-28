package racing;

import java.util.Scanner;

public class RacingApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = sc.nextLine();

        System.out.println("최종우승자: " + String.join(", ",
                new Judgement(
                    new Racing(
                        CarGenerator.createCars(carNames)
                    ).race()
                ).judgeWinner()
            )
        );
    }
}
