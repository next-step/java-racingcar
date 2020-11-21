package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static final String DISTANCE = "-";

    public static void print(CarRace carRace){
        for(int i=0; i < carRace.getTryCnt(); i++){
            carRace.getRaceResult().get(i).cars.stream().forEach(c -> {
                System.out.println(c.getName()+" : "+getDistanceToUI(c));
            });
            System.out.println();
        }
    }

    public static String getDistanceToUI(CarSnapshot carSnapshot){
        String result = "";
        for(int i=0; i < carSnapshot.getDistance(); i++){
            result += DISTANCE;
        }
        return result;
    }

    public static void printWinner(List<Car> winnerCars){
        String winnerName = String.join(",", winnerCars.stream()
                .map(s -> s.getName())
                .collect(Collectors.toList()));
        System.out.println(winnerName + "가 최종 우승했습니다.");

    }

}
