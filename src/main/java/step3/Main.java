package step3;

import step3.model.CarList;
import step3.service.MoveOrStop;
import step3.view.Input;
import step3.view.Output;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        input.inputView();
        ArrayList<String> inputCarList = new CarList().makeCarList(input.getCountOfCar());
        Output output = new Output(inputCarList, input.getCountOfTry());
        output.outputView();
    }
}
