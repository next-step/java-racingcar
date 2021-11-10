package step3.view;

import step3.model.CarList;
import step3.service.ConvertOutputView;
import step3.strategy.MoveStrategy;

public class Output {

    public static void  outputView(CarList carList, MoveStrategy moveStrategy, Integer countOfTry) {
        System.out.println("실행 결과");
        for (int i = 0; i < countOfTry; i++) {
            carList.movableCarList(moveStrategy);
            carList.getCarList().stream().map(car -> ConvertOutputView.convertOutputView(car.getPosition())).forEach(System.out :: println);
            System.out.println("");
        }

    }
}
