package racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RacingApplication {

    public static void main(String[] args) throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String carNames = br.readLine();

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
