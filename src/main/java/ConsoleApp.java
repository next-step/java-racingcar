import domain.Car;
import domain.RacingGame;
import domain.RandomNumberRule;
import io.ConsoleInput;
import io.Input;
import java.util.List;

public class ConsoleApp {

    public static void main(String[] args) {
        Input input = new ConsoleInput();

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String[] cars = input.nextLine().split(",");

        System.out.println("시도할 횟수는 몇 회 인가요?");
        Integer gameCount = input.nextInt();

        RacingGame racingGame = new RacingGame(new RandomNumberRule(0, 10, 4), gameCount, cars);
        List<Car> result = racingGame.play();

        System.out.println("실행 결과");
        carMileage(result);
    }

    private static void carMileage(List<Car> cars) {
        for (Car car : cars) {
            System.out.print("-");
            for (int i = 0; i < car.getMileage(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}