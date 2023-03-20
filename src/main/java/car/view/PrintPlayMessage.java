package car.view;

import car.domain.Car;

import java.util.List;

public class PrintPlayMessage {

    public static void printScoreMessage(Car car) {
        StringBuilder carRacingScore = new StringBuilder();
        for (int j = 0; j < car.getPosition(); j++) {
            carRacingScore.append("-");
        }
        System.out.println(car.getName() + " : " + carRacingScore);
    }

    public static void printPlayMessage(String message) {
        System.out.println(message);
    }

    public static void printResultMessage(List<String> message) {
        System.out.println("최중 우승자 : " + message);
    }

    public static void printResultStartMessage(){
        System.out.println("실행결과");
    }
}
