package racing.view;

import exception.CustomException;
import racing.module.Car;

import java.util.List;

public class OutputView {
    private OutputView() throws CustomException {
        throw new CustomException("유틸성 클래스입니다.");
    }

    public static void printCarsPosition(List<Car> carList) {
        for (Car car : carList) {
            System.out.print("#"); // 출발선
            printCarPosition(car.getPosition());
            System.out.print("\n");
        }

    }

    public static void printCarPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }
}
