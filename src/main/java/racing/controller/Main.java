package racing.controller;

import racing.domain.Cars;
import racing.domain.Racing;
import racing.domain.strategy.RandomMoveStrategyImpl;
import racing.view.Input;
import racing.view.Output;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> nameList = Input.getNameList();
        Cars cars = new Cars(nameList);
        Integer countOfTry = Input.getCuntOfTry();
        Racing racing = new Racing();
        racing.racing(cars, countOfTry, new RandomMoveStrategyImpl());
    }
}