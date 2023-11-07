package racing;

import racing.car.Car;
import racing.car.Position;

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
    public List<Car> participatingCars() {
        return participatingCars.cars();
    }

    /**
     * 우승한 자동차들을 반환한다.
     *
     * @return
     */
    public List<Car> winners() {
        return this.participatingCars.winners();
    }

    private List<Car> attemptGo() {
        List<Car> cars = new ArrayList<>();
        for (Car car : this.participatingCars()) {
            int input = random.nextInt(RANDOM_SEED_NUMBER);
            car.move(input);
            cars.add(new Car(car.name().toString(), car.position().position()));
        }
        return cars;
    }

    public List<List<Car>> result() {
        List<List<Car>> result = new ArrayList<>();
        for (int i = 0; i < attemptCount; ++i) {
            result.add(attemptGo());
        }
        return result;
    }

    public static class ParticipatingCars {

        private final List<Car> participatingCars = new ArrayList<>();

        public ParticipatingCars(String inputNames) {
            String[] names = inputNames.split(",");
            for (String name : names) {
                this.participatingCars.add(new Car(name, INIT_POSITION));
            }
        }

        public List<Car> cars() {
            return this.participatingCars;
        }

        public List<Car> winners() {
            List<Car> winners = new ArrayList<>();
            Position position = new Position(INIT_POSITION);
            for (Car car : this.participatingCars) {
                position = checkWinner(winners, position, car);
            }
            return winners;
        }

        private static Position checkWinner(List<Car> winners, Position position, Car car) {
            switch (position.compareTo(car.position())) {
                case 0:// 같을 때
                    winners.add(car);
                    break;
                case 1:// 새로운 자동차가 더 앞에 있을 때
                    winners.clear();
                    winners.add(car);
                    position = new Position(car.position().position());
                    break;
                default:
                    break;
            }
            return position;
        }
    }
}
