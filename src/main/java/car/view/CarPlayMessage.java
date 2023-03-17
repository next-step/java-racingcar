package car.view;

import java.util.List;

public class CarPlayMessage {

    public static void playScoreMessage(String name, int score) {
        StringBuilder carRacingScore = new StringBuilder();
        for (int j = 0; j < score; j++) {
            carRacingScore.append("-");
        }
        System.out.println(name + " : " + carRacingScore);
    }

    public static void carPlayMessage(String message) {
        System.out.println(message);
    }

    public static void playResultMessage(List<String> message) {
        System.out.println("최중 우승자 : " + message);
    }
}
