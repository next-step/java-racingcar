package racingCar.ui;

import java.util.List;

public class PrintService {

    static public void printDistance(int number){
        String distance = getDistance(number);
        System.out.println(distance);
    }

    static public void printDistanceWithName(int number, String name){
        String distance = getDistance(number);
        System.out.println(name +" : "+distance);
    }

    private static String getDistance(int number) {
        StringBuilder distance = new StringBuilder();
        for(int i = 0; i< number; i++){
            distance.append("-");
        }
        return distance.toString();
    }

    public static void printEmptyLine(){
        System.out.println();
    }

    public static void printWinners(List<String> winners){
        String winner = String.join(",",winners);
        System.out.println(winner + "가 최종 우승했습니다.");
    }

}
