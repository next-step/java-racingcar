package car;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();
    private static CarMove carMove = new CarMove();
    public static void main(String[] args) {

        System.out.println("자동차 대수는 몇 대 인가요?");
        List<Car> cars = carAttendList(inputView.inputValue());

        System.out.println("시도할 회수는 몇 회 인가요?");
        int frequency = inputView.inputValue();
        for (int i = 0; i < frequency; i++) {
            System.out.println("++++++++++++++");
            carMovingState(cars);
        }
    }

    public static void carMovingState(List<Car> cars){
        for (Car car : cars){
            car.move(car.randomMoveStrategy());
            resultView.resultView(car.getPosition());
        }
    }
    public static ArrayList<Car> carAttendList(int count){
        ArrayList<Car> cars = new ArrayList<Car>();
        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }
        return cars;
    }






}
