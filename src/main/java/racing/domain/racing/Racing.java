package racing.domain.racing;

import racing.domain.car.Car;
import racing.domain.car.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    private static final Random random = new Random();
    private static final int RANDOM_SEED_NUMBER = 10;
    private static final int INIT_POSITION = 0;

    private final ParticipatingCars participatingCars;
    private final int attemptCount;

    public Racing(String inputNames, int attemptCount) {
        this.participatingCars = new ParticipatingCars(inputNames);
        this.attemptCount = attemptCount;
    }

    /**
     * 대회에 참여중인 자동차를 반환한다.
     *
     * @return
     */
    public ParticipatingCars participatingCars() {
        return participatingCars;
    }

    /**
     * 우승한 자동차들을 반환한다.
     *
     * @return
     */
    public List<Car> winners() {
        return this.participatingCars.winners();
    }

    public List<List<Car>> result() {
        List<List<Car>> result = new ArrayList<>();
        for (int i = 0; i < attemptCount; ++i) {
            result.add(attemptGo());
        }
        return result;
    }

    private List<Car> attemptGo() {
        List<Car> cars = new ArrayList<>();
        for (Car car : this.participatingCars().cars()) {
            int input = random.nextInt(RANDOM_SEED_NUMBER);
            car.move(input);
            cars.add(new Car(car.name().toString()));
        }
        return cars;
    }


    public static class ParticipatingCars {

        private final List<Car> participatingCars = new ArrayList<>();

        public ParticipatingCars(String inputNames) {
            String[] names = inputNames.split(",");
            for (String name : names) {
                this.participatingCars.add(new Car(name));
            }
        }

        public int numberOfCars() {
            return this.participatingCars.size();
        }

        public List<Car> cars() {
            return this.participatingCars;
        }

        private List<Car> winners() {
            List<Car> winners = new ArrayList<>();
            Position max = max();
            for (Car car : this.participatingCars) {
                if (car.position().equals(max)) {
                    winners.add(car);
                }
            }
            return winners;
        }

        private Position max() {
            int max = 0;
            for (Car car : this.participatingCars) {
                if (max < car.position().position()) {
                    max = car.position().position();
                }
            }
            return new Position(max);
        }
    }
}
