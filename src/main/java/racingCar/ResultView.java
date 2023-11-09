package racingCar;

import java.util.List;

public class ResultView {

    private ResultView(){}

    public static void print(int printCnt){
        for(int i=0; i<printCnt; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printNamedCar(String carName, int printCnt){
        System.out.print(carName+" : ");
        for(int i=0; i<printCnt; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners){
        for(int i=0; i<winners.size()-1; i++){
            System.out.print(winners.get(i) + ", ");
        }
        System.out.print(winners.get(winners.size()-1) + "가 최종 우승했습니다.");

    }

}
