import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCnt = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int playCnt = scanner.nextInt();

        Random random = new Random();
        DiceRoller diceRoller = new DiceRollerImpl(random);
        List<Car> cars = IntStream.range(0, carCnt).boxed().map(e -> new Car(diceRoller)).collect(Collectors.toList());
        for (int i = 0; i < playCnt; i++) {
            for (Car car : cars) {
                car.printLength();
                System.out.println();
                car.go();
            }
            System.out.println();
        }
    }
}
