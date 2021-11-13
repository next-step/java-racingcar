package racing;

import racing.model.Cars;
import racing.strategy.RandomMoveStrategyImpl;
import racing.view.Input;
import racing.view.Output;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> nameList = Input.getNameList();
        Integer countOfTry = Input.getCuntOfTry();
        Cars cars = new Cars(nameList);
        Output.outputView(cars,new RandomMoveStrategyImpl(),countOfTry);
    }
}