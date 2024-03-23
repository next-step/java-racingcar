package racing.view;


import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Winners;

import java.util.List;

public class ResultView {


    public static void printCars(Cars cars) {
        for (Car car : cars.cars()) {
            printPositionWithName(car);
            System.out.println();
        }
        System.out.println();
    }

    private static void printPositionWithName(Car car){
        System.out.print(car.getName() + " : ");
        for(int count = 0; count < car.getPosition(); count++){
            System.out.print("-");
        }
    }

    public static void printWinners(Winners winners) {
        List<Car> winnerList = winners.winners();
        for (int index = 0; index < winnerList.size(); index++) {
            System.out.print(winnerList.get(index).getName());
            printColon(winnerList, index);
        }
        System.out.println("가 최종 우승했습니다.");
    }

    private static void printColon(List<?> objectList,
                                   int index){
        if (index < objectList.size() - 1)
            System.out.print(", ");
    }
}