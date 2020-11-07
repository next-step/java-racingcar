package car.racing;

import java.util.List;

public class ResultView implements ResultViewContract {

    @Override
    public void resultTitle() {
        System.out.println("\n실행 결과");
    }

    @Override
    public void newLine() {
        System.out.println();
    }

    @Override
    public void forward(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.forwardResult()));
    }

    @Override
    public void winners(String racingWinners) {
        System.out.print(racingWinners);
        System.out.println("가 최종 우승했습니다.");
    }
}