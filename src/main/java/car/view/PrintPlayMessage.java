package car.view;

import java.util.List;

public class PrintPlayMessage {

    public static void printScoreMessage(String name, int score) {
        StringBuilder carRacingScore = new StringBuilder();
        for (int j = 0; j < score; j++) {
            carRacingScore.append("-");
        }
        System.out.println(name + " : " + carRacingScore);
    }

    public static void printPlayMessage(String message) {
        System.out.println(message);
    }

    public static void printResultMessage(List<String> message) {
        System.out.println("최중 우승자 : " + message);
    }
}
