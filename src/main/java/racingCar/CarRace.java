package racingCar;

import java.util.List;
        import java.util.Optional;
        import java.util.Random;
        import java.util.stream.Collectors;

public class CarRace {
    private final List<Car> participationCars;
    private final int count;
    private final Random random;

    public CarRace(List<Car> participationCars, int count, Random random) {
        this.participationCars = participationCars;
        this.count = count;
        this.random = random;
    }

    public void startRace() {
        System.out.println("실행결과");
        for (int i = 0; i < count; i++) {
            participationCars.forEach(c -> {
                c.move(random);
                c.print();
            });
            System.out.println();
        }
    }

    public List<Car> getRacingWinners() {
        Optional<Car> max = participationCars.stream().max(Car::compareTo);
        Car winner = max.orElseThrow();
        return participationCars.stream().filter(c -> c.isEqualLocation(winner)).collect(Collectors.toList());
    }

    public void printRacingWinners() {
        List<Car> racingWinners = getRacingWinners();
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < racingWinners.size(); i++) {
            Car car = racingWinners.get(i);
            System.out.print(car);

            if (i + 1 != racingWinners.size()) {
                System.out.print(",");
            }
        }
    }
}