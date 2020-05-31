package step4;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public ResultView() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void showResult(Cars cars, boolean lastGame) {
        cars.getCars().forEach(it -> {
            System.out.print(it.getName() + " : ");
            printPosition(it.getPosition());
        });
        System.out.println();

        if (lastGame) showWinner(cars);
    }

    private void printPosition(int position) {
        for (int i = 0; i <= position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void showWinner(Cars cars) {
        String winners = String.join(",", calcWinner(cars));
        System.out.println(winners + "가 최종 우승했습니다.");
    }

    private List<String> calcWinner(Cars cars) {
        int maxPosition = cars.getCars().stream().mapToInt(Car::getPosition).max().getAsInt();
        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
