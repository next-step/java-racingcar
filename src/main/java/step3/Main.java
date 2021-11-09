package step3;

import step3.model.CarList;
import step3.service.MoveOrStop;
import step3.view.Input;
import step3.view.Output;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();

        ArrayList<Integer> inputList = input.inputView();

        Integer countOfCar = inputList.get(0);
        Integer countOfTry = inputList.get(1);

        ArrayList<String> inputCarList = CarList.makeCarList(countOfCar);
        output.outputView(countOfTry,inputCarList);
    }
}
