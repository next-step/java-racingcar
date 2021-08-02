package view;

import domain.Car;

import java.util.List;
import java.util.StringJoiner;

public class ResultView {

    public static void racingView(List<Car> players) {
        StringBuffer sb = new StringBuffer();
        for(Car plalyer : players) {
            setPlayerView(sb, plalyer);
        }
        System.out.println(sb.toString());
    }

    public static void setPlayerView(StringBuffer sb, Car car) {
        sb.append(car.readParticipantName());
        sb.append(" : ");

        for (int distance = 0; distance < car.readCarDistance(); distance++) {
            sb.append("-");
        }
        sb.append("\r\n");
    }

    public static void winnersView(List<Car> winners) {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (Car winner : winners) {
            stringJoiner.add(winner.readParticipantName());
        }
        System.out.println(stringJoiner.toString() + "가 최종 우승했습니다.");
    }

}
