package racing.view;

import racing.domain.Cars;
import racing.domain.ConvertOutputView;
import racing.domain.strategy.MoveStrategy;

public class Output {

    private Output() {
    }

    public static void  outputView(Cars cars, MoveStrategy moveStrategy, Integer countOfTry) {
        System.out.println("실행 결과");
        for (int i = 0; i < countOfTry; i++) {
            cars.playRacing(moveStrategy);
            cars.getCarList().stream().map(car -> car.getName().getName() + ": " + ConvertOutputView.convertOutputView(car.getPosition())).forEach(System.out :: println);
            System.out.println("");
        }
        cars.findWinnerList().stream().map(i->i.getName().getName()+" ").forEach(System.out::printf);
        System.out.printf("우승하셨습니다");
    }
}
