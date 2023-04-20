package car.step3;

import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int MAX_LOCATION = 0;
    public static List<String> winners = new ArrayList<>();
    public static void main(String[] args) {
        InputView inputView = new InputView();
        HandleCar handleCar = new HandleCar();
        ResultView resultView = new ResultView();
        //자동차 대수
        String carNames = inputView.scannerCarCertain();
        List<Car> cars = makeCar(carNames);
        //시도할 횟수
        int number = inputView.scannerCarNumber();
        // 시도할 횟수만큼 시도한다. 랜덤 값이 4 이상이면 전진한다.
        System.out.println("실행 결과");
        for (int i = 0; i < number; i++) {
            cars = handleCar.iteratorCar(cars);
            resultView.result(cars);
        }
        resultView.winnerResult(cars);

    }

    private static List<Car> makeCar(String carNames) {
        List<Car> carList = new ArrayList<Car>();
        String[] cars =  carNames.split(",");
        for (String car : cars) {
            carList.add(new Car(validCarName(car)));
        }
        return carList;
    }

    private static String validCarName(String name) {
        if(name.length() > 5) {
            throw new RuntimeException("이름은 5자를 초과할 수 없습니다.");
        }
        return name;
    }



}
