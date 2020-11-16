package carRace.step5.view;

import java.util.List;

public class CarRasingDraw {

    public static void printCarDistance(String carName, int moveDistance){
        System.out.println(carName + " : " + changeNumberToChar(moveDistance));
    }

    public static void printWinner(List<String> winnerList){
        System.out.print("우승자 : " + winnerList.get(0));
        for (int i = 1; i < winnerList.size(); i++) {
            System.out.print(", " + winnerList.get(i));
        }
    }

    private static String changeNumberToChar(int count) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append("-");
        }

        return sb.toString();
    }
}
