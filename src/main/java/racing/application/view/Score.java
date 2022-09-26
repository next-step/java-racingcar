package racing.application.view;

import java.util.ArrayDeque;
import java.util.Objects;
import racing.domain.car.Car;
import racing.domain.car.Name;
import racing.domain.car.Track;
import racing.domain.score.History;

public class Score {

    private final History history;
    private final Winner winner;

    public Score(History history, Winner winner) {
        this.history = history;
        this.winner = winner;
    }

    public Score(Track track) {
        this(track.getHistory(), new Winner(track.winner()));
    }

    public void printGame() {
        history.history().forEach(cars -> {
            cars.cars().forEach(this::printCar);
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

    private void printCar(Car car) {
        String position = "-".repeat(car.position());
        System.out.printf("%s: %s\n", car.name().value(), position);
    }
}
