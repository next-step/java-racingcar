package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    public static void result(List<Car> car){
        for (Car selectedOneCar : car){
            System.out.println(positionGrid(selectedOneCar));
        }
        System.out.println();
    }

    public static String positionGrid(Car selectedOneCar){
        String str = "";
        str += selectedOneCar.getName() + " : ";
        for(int i = 0; i < selectedOneCar.getPosition(); i++){
            str += "-";
        }
        return str;
    }

    public static String printWinner(List<String> winners){
        System.out.println(String.join(", ", winners) + " 가 최종 우승했습니다.");
        return String.join(", ", winners) + " 가 최종 우승했습니다.";
    }
}
