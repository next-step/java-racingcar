package step3;

import step3.model.Car;
import step3.model.CarList;
import step3.strategy.RandomMoveStrategyImpl;
import step3.view.Input;
import step3.view.Output;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        List<Integer> inputList = input.inputView();
        Integer countOfCar = inputList.get(0);
        Integer countOfTry = inputList.get(1);

        CarList carList = new CarList(countOfCar);

        Output output = new Output();
        output.outputView(carList,new RandomMoveStrategyImpl(),countOfTry);




    }
}
