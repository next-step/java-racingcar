package car;

import car.Impl.CarMove;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();
    public static void main(String[] args) {



        System.out.println("자동차 대수는 몇 대 인가요?");
        List<CarMove> cars = carAttendList(inputView.inputValue());

        System.out.println("시도할 회수는 몇 회 인가요?");
        int frequency = inputView.inputValue();
        for (int i = 0; i < frequency; i++) {
            System.out.println("++++++++++++++");
            carMovingState(cars);
        }
    }

    public static void carMovingState(List<CarMove> cars){
        for (CarMove car : cars){
            resultView.resultView(car.goStop());
        }
    }
    public static ArrayList<CarMove> carAttendList(int count){
        ArrayList<CarMove> cars = new ArrayList<CarMove>();
        for (int i = 0; i < count; i++) {
            cars.add(new CarMove());
        }
        return cars;

    }






}
