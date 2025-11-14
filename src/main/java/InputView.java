import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static List<Car> readCarsInput() {
        Scanner scanner = new Scanner(System.in);
        print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = scanner.nextLine().split(",");

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public static int readRoundCountInput() {
        Scanner scanner = new Scanner(System.in);
        print("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    private static void print(String text) {
        System.out.println(text);
    }
}
