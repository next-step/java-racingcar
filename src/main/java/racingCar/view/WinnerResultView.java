package racingCar.view;

import racingCar.domain.Car;
import racingCar.domain.Cars;
import racingCar.domain.Winners;

import java.util.List;
import java.util.Map;

public class WinnerResultView {

    public static void main(String[] args) {
        Map<String, Object> inputMap = WinnerInputView.input();
        String carNames = inputMap.get("carNames").toString();
        int tryNum = (int) inputMap.get("tryNum");

        Cars cars = new Cars(carNames);

        for(int i=0; i< tryNum; i++){
            cars.addCarMoving();
            printNamedCar(cars.getCarList());
        }

        printWinner(Winners.findWinner(cars.getCarList()));
    }

    public static void printEachNamedCar(Car car){
        System.out.print(car.getCarName() + " : ");
        for(int i=0; i < car.getForwardCount(); i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printNamedCar(List<Car> carList){
        for(Car car : carList) {
            printEachNamedCar(car);
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners){
        for(int i=0; i < winners.size()-1; i++){
            System.out.print(winners.get(i) + ", ");
        }
        System.out.print(winners.get(winners.size()-1) + "가 최종 우승했습니다.");

    }
}
