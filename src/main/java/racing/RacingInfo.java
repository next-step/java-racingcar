package racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class RacingInfo {

    private final List<Car> cars;
    private final Round round;
    private final MoveRule moveRule;

    public RacingInfo(List<Car> cars, Round round, MoveRule moveRule) {
        this.cars = cars;
        this.round = round;
        this.moveRule = moveRule;
    }

    public static RacingInfo init() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner sc = new Scanner(System.in);
        String carNames = sc.nextLine();

        final List<Car> cars = CarGenerator.createCars(carNames);
        MoveRule moveRule = initMoveRule(4);
        Round round = initRound();

        return new RacingInfo(cars, round, moveRule);
    }

    private static Round initRound() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("시도할 횟수는 몇회인가요?");
            return new Round(Integer.parseInt(br.readLine()));
        } catch (IOException e) {
            System.out.println("[ERROR] 입출력 예외 발생");
        }
        return null;
    }

    private static MoveRule initMoveRule(int moveCondition) {
        return new MoveRule(moveCondition);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Round getRound() {
        return round;
    }

    public MoveRule getMoveRule() {
        return moveRule;
    }
}
