package racing;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> participationCars;
    private final int count;

    public Race(List<Car> participationCars, int count) {
        this.participationCars = participationCars;
        this.count = count;
    }

    public void startRace() {
        System.out.println("실행결과");
        for (int i = 0; i < count; i++) {
            participationCars.forEach(c -> {
                c.move();
                c.print();
            });
            System.out.println();
        }
    }

    private List<Car> getRacingWinners() {
        Optional<Car> max = participationCars.stream().max((c1, c2) -> c1.compare(c1, c2));
        Car winner = max.get();
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
