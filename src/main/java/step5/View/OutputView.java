package step5.View;


import step5.domain.Car;
import step5.domain.Cars;
import java.util.Map;
import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class OutputView {

    private static Map<String, Integer> carsMap = new HashMap<>();
    public static void printStart() {
        System.out.println("실행결과");
    }

    public static void printCarMove(Cars cars) {
        List<Car> carMoves = cars.getCars();
        for (Car car : carMoves) {
            carsMap.put(car.getName(), carsMap.getOrDefault(car.getName(), car.getPosition()) + car.getPosition());
            System.out.println(car.getName() + ":" + replacePositionToString(car.getPosition()));
        }
    }

    public static void printWinner() {
        List<String> winner = new ArrayList<>();
        int max = carsMap.values()
                .stream()
                .mapToInt(Integer::intValue)
                .max().getAsInt();

        carsMap.forEach(
                (k,v) -> {
                    if(v >= max) {
                       winner.add(k);
                    }
                }
        );
        String winners = winner.stream().collect(Collectors.joining(","));
        System.out.println(winners+"가 최종 우승하였습니다.");

    }

    private static String replacePositionToString(int position) {
        String replacePosition ="";
        for (int i = 0; i < position; i++) {
            replacePosition += "-";
        }
        return  replacePosition;
    }
}
