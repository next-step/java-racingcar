package racing.view;

import racing.domain.Cars;
import racing.domain.ConvertOutputView;
import racing.domain.strategy.MoveStrategy;

public class Output {

    private Output() {
    }

    public static void startOutputView() {
        System.out.println("실행 결과");
    }

    public static void  racingOutputView(Cars cars) {
        cars.getCarList().stream().map(car -> car.getName().getName() + ": " + ConvertOutputView.convertOutputView(car.getPosition())).forEach(System.out::println);
        System.out.println("");
    }

    public static void endOutputView(Cars cars) {
        cars.findWinnerList().stream().map(i->i.getName().getName()+" ").forEach(System.out::printf);
        System.out.printf("우승하셨습니다");
    }
}
