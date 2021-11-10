package step3;

import step3.model.CarList;
import step3.strategy.RandomMoveStrategyImpl;
import step3.view.Input;
import step3.view.Output;

public class Main {
    public static void main(String[] args) {

        Integer countOfCar = Input.getCuntOfCar();
        Integer countOfTry = Input.getCuntOfTry();

        CarList carList = new CarList(countOfCar);

        Output.outputView(carList,new RandomMoveStrategyImpl(),countOfTry);
    }
}
