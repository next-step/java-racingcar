package racing.application.view;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;
import racing.domain.car.Car;
import racing.domain.car.CarRace;
import racing.domain.car.Name;

public class Score {

    private final List<CarRace> carRaces;
    private final Winner winner;

    public Score(List<CarRace> carRaces, Winner winner) {
        this.carRaces = carRaces;
        this.winner = winner;
    }

    public void printGame() {
        carRaces.forEach(carRace -> {
            carRace.cars().forEach(this::printCar);
            System.out.println();
        });
    }

    public void printWinner() {
        ArrayDeque<Name> names = new ArrayDeque<>(winner.winners());

        StringBuilder winner = new StringBuilder();

        while (names.size() > 1) {
            Name poll = names.poll();
            winner.append(poll.value())
                .append(",");
        }
        String last = String.format("%s이(가) 최종 우승했습니다.", Objects.requireNonNull(names.poll()).value());
        winner.append(last);

        System.out.println(winner);

    }

    public int size() {
        return carRaces.size();
    }

    private void printCar(Car car) {
        String position = "-".repeat(car.position());
        System.out.printf("%s: %s\n", car.name().value(), position);
    }
}
