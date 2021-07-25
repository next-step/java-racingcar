package step4.view;

import step4.model.Car;

import java.util.List;

public class Print {

    public static void print(String message){
        System.out.println(message);
    }

    public static void print(List list){
        for(Object item : list){
            print(item.toString());
        }
    }

    public static void print(Integer... count){
        for (Integer integer : count) {
            print(ToDash.positionToDash(integer));
        }
    }

    public static void print(Car... cars){
        for(Car car : cars){
            print(car);
        }
    }

    public static void printWinner(List<Car> cars){
        // pobi, honux가 최종 우승했습니다.
        StringBuffer winners = new StringBuffer("");
        for(Car car: cars){
            winners.append(car.getName());
            winners.append(", ");
        }
        print(winners.substring(0,winners.length()-2) + "가 최종 우승했습니다.");
    }

}
