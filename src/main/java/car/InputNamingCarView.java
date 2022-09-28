package car;

import java.util.List;
import java.util.Scanner;

public class InputNamingCarView implements InputView {
    private NamingCarFactory carFactory;

    public InputNamingCarView() {
        this.carFactory = new NamingCarFactory();
    }

    @Override
    public List<Car> enterCar() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] carNames = input.split(",");
        return carFactory.generateCar(carNames);
    }

    @Override
    public int enterTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
