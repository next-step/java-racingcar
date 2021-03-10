package racingcar;

import java.util.List;

public class PrintView {

    public void printResultTitle() {
        System.out.println("실행 결과");
    }

    public void printCarStatus(List<Car> carList) {
        StringBuilder currentStatus = new StringBuilder();
        carList.stream()
                .map(Car::getPosition)
                .forEach(position -> {
                    for (int i = 0; i < position; i++) {
                        currentStatus.append("-");
                    }
                    currentStatus.append("\n");
                });
        System.out.println(currentStatus.toString());
    }
}
