package racingcar.view;

import racingcar.domain.Car;
import java.util.List;

public class Output {
    public static void printInputMessage(String inputInfo){
        System.out.println(inputInfo + "을(를) 입력해주세요.");
    }

    public static void printCurrentCarsState(List<Car> cars){
        System.out.println("\n실행 결과");
        for(Car car : cars){
            printCarInfo(car);
        }
    }

    private static void printCarInfo(Car car){
        StringBuffer carInfo = new StringBuffer();
        carInfo.append(car.getName());
        carInfo.append(" : ");
        for(int i = 0; i < car.getDistance(); ++i){
            carInfo.append("-");
        }
        System.out.println(carInfo);
    }

    public static void printWinners(List<Car> cars, int maxDistance) {
        System.out.print("최종 우승자 : ");
        for(Car car : cars) {
            printWinner(car, maxDistance);
        }
        System.out.println("");
    }

    private static void printWinner(Car car, int maxDistance) {
        if(car.getDistance() == maxDistance) {
            System.out.print(car.getName() + " ");
        }
    }
}
