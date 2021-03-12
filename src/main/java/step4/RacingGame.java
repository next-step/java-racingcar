package step4;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private static final int RANDOM_SCOPE = 10;
    private final List<Car> cars;
    List<Car> list;
    private final int attempt;
    private Random random = new Random();

    public RacingGame(InputView inputView) {
        String names = inputView.inputNames();
        int attempt = inputView.inputAttempt();
        this.cars = createCars(names);
        this.attempt = attempt;
    }

    private List<Car> createCars(final String names) {
        final List<Car> cars = new ArrayList<>();
        for(String name : names.split(",")) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void start() {
        int round = attempt;

        while (round-- != 0) {
            move();
        }
        System.out.println(winner() + "가 최종 우승했습니다.");
    }

    private void move() {
        list = new ArrayList<>();
        for (Car car : cars) {
            car.move(random.nextInt(RANDOM_SCOPE));
            new ResultView(car).printEachCar();
            list.add(car);
        }
        roundWinner();
        println();
    }

    private boolean isGreaterOrEquals(int n, int advance) {
        return advance >= n;
    }

    Map<String, Integer> map = new HashMap<>();
    private List<String> roundWinner() {
        List<String> carList = list.stream()
                .filter(it -> isGreaterOrEquals(maxOfList(), it.getAdvance()))
                .sorted(Comparator.comparing(Car::getAdvance).reversed())
                .map(Car::getName)
                .collect(Collectors.toList());

        for (String name : carList) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        return carList;
    }

    private String winner() {
        List<String> winner = new ArrayList<>();
        int max = map.values()
                .stream()
                .mapToInt(x -> x)
                .max()
                .getAsInt();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            if (max <= v) winner.add(k);

        }
        return winner.stream().collect(Collectors.joining(","));
    }

    private int maxOfList() {
        int n = list.stream()
                .map(Car::getAdvance)
                .max(Comparator.comparing(x -> x))
                .get();

        return n;
    }

    private void println() {
        System.out.println();
    }
}
