package racingcar;

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

    public static void printWinner(List<Car> winners){
        String str = "";
        for(Car car : winners){
            str += car.getName() + ", ";
        }
        System.out.println(str + "가 최종 우승했습니다.");
    }
}
