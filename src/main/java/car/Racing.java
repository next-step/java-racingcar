package car;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요");
        List<Car> cars = carAttendList(inputView.carAttendNameSeparation(inputView.inputStringValue()));

        System.out.println("시도할 회수는 몇 회 인가요?");
        int frequency = inputView.inputIntegerValue();
        for (int i = 0; i < frequency; i++) {
            System.out.println("++++++++++++++");
            carMovingState(cars);
        }
    }

    public static void carMovingState(List<Car> cars){
        for (Car car : cars){
            car.move(car.randomMoveStrategy());
            resultView.resultView(car);
        }
    }
    public static ArrayList<Car> carAttendList(String[] names){
        ArrayList<Car> cars = new ArrayList<Car>();
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(inputView.carNameCheck(names[i])));
        }
        return cars;
    }









}
