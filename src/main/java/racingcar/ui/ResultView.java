package racingcar.ui;

import racingcar.Car;
import racingcar.Cars;

import java.util.List;

public class ResultView {

    public static void printMovingCars(Cars cars){
        for (Car car : cars.getCars()) {
            printMovingCar(car);
        }
        System.out.println();
    }

    private static void printMovingCar(Car car) {
        System.out.print(car.getName() + " : ");
        for(int i=0; i<car.getPosition(); i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        if(isNotExistWinner(winners)){
            System.out.println("우승자가 존재하지 않습니다.");
            return;
        }
        StringBuffer sb = extractWinnerString(winners);
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb);
    }

    //이 부분이 뭔가 별로인데 리팩토링 어떻게 할 수 있을까요??
    private static StringBuffer extractWinnerString(List<Car> winners) {
        StringBuffer sb = new StringBuffer("");
        for(int i=0; i<winners.size()-1; i++){
            sb.append(winners.get(i).getName()).append(", ");
        }
        sb.append(winners.get(winners.size()-1).getName());
        return sb;
    }

    private static boolean isNotExistWinner(List<Car> winners) {
        return winners.isEmpty();
    }
}
