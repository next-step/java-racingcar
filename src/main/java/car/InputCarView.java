package car;

import java.util.List;
import java.util.Scanner;

public class InputCarView implements InputView {
    private final CarFactory carFactory;

    public InputCarView() {this.carFactory = new RacingCarFactory();}

    @Override
    public List<Car> enterCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        return carFactory.generateCar(num);
    }

    public int enterTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
