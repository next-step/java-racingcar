package racingCar.view;

import racingCar.domain.Car;

import java.util.List;

public class ResultView {

    private ResultView(){}

    public static void printCar(Car car){
        for(int i=0; i < car.getForwardCount(); i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printNamedCar(Car car){
        System.out.print(car.getCarName() + " : ");
        for(int i=0; i < car.getForwardCount(); i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners){
        for(int i=0; i < winners.size()-1; i++){
            System.out.print(winners.get(i) + ", ");
        }
        System.out.print(winners.get(winners.size()-1) + "가 최종 우승했습니다.");

    }

    public static void printNewLine(){
        System.out.println();
    }

}
