package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public class RacingResult {

    private static String RESULT_LINE = "%s : ";
    private static String DASH = "-";
    private List<Car> cars;

    private RacingResult(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingResult getInstance(List<Car> cars) {
        return new RacingResult(cars);
    }

    public void getResultView() {
        int carSize = cars.size();
        for (int i = 0; i < carSize; i++) {
            StringBuilder stringBuilder = new StringBuilder();

            int position = cars.get(i).getPosition();
            System.out.printf(RESULT_LINE, cars.get(i).getName());
            for (int pos = 0; pos < position; pos++) {
                stringBuilder.append(DASH);
            }
            System.out.println(stringBuilder.toString());
        }
        System.out.println();
    }

    public String getWinner() {
        System.out.print("최종 우승자: ");
        //StringBuilder stringBuilder = new StringBuilder("최종 우승자: ");

        Collections.sort(cars);
        Car firstWinner = cars.get(0);

        String winners = cars.stream()
            .filter(car -> car.compareStatus(firstWinner))
            .map(car -> car.getName())
            .collect(Collectors.joining(", "));

        return winners;

        //System.out.println(stringBuilder.append(winners).toString());
    }

    public List<Car> getResult() {
        return this.cars;
    }

    public static RacingResult toRacingResult(Participants participants) {
        return RacingResult.getInstance(participants.getParticipants());
    }
}
