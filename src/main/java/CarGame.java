import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.next();
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCnt = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int playCnt = scanner.nextInt();

        Random random = new Random();
        DiceRoller diceRoller = new DiceRollerImpl(random);
        String[] split = names.split(",");
        List<Car> cars = IntStream.range(0, carCnt).boxed().map(e -> new Car(diceRoller, split[e])).collect(Collectors.toList());
        for (int i = 0; i < playCnt; i++) {
            for (Car car : cars) {
                car.printLength();
                System.out.println();
                if (i != playCnt-1) car.go();
            }
            System.out.println();
        }

        Referee referee = new Referee(cars);
        System.out.println(referee.getWinnersCarNames() + "가 최종 우승 했습니다.");
    }
}
