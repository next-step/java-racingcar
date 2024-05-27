package Controller;

import Model.Car;
import View.ErrorMessage;
import View.Output;

import java.util.ArrayList;

public class Controller {
    ErrorMessage errorMessage = new ErrorMessage();
    Output output = new Output();
    ArrayList<Car> carList;
    int count;

    public void run(){
        carList = errorMessage.catchNameException();
        count = errorMessage.catchCountException();
        play();
        output.printWinner(carList);
    }

    public void play(){
        System.out.println("\n실행결과");
        for(int i = 0; i < count; i++){
            for(int j = 0; j < carList.size(); j++){
                carList.get(j).move();
            }
            output.printResult(carList);
        }
    }
}
