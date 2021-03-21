package carracing.view;

import carracing.vo.Car;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class InputView {

    private final String CAR_COUNT_QUESTION = "자동차 대수는 몇대인가요?";
    private final String TRY_COUNT_QUESTION = "시도할 횟수는 몇회인가요?";

    public Car input() {
        Scanner scanner = new Scanner(System.in);
        Car car = new Car();

        System.out.println(CAR_COUNT_QUESTION);
        int carCount = scanner.nextInt();
        System.out.println(TRY_COUNT_QUESTION);
        int tryCount = scanner.nextInt();

        car.setCarCount(carCount);
        car.setTryCount(tryCount);

        return car;
    }
}
