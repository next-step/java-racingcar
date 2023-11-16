package racing.domain.racing;

import java.util.Arrays;
import racing.domain.car.Car;
import racing.domain.car.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    private final ParticipatingCars participatingCars;

    public Racing(String inputNames) {
        this.participatingCars = new ParticipatingCars(inputNames);
    }

    public void race(int[] randomNumbers) {
        for (int i = 0; i < this.participatingCars.numberOfCars(); ++i) {
            this.participatingCars.cars().get(i).move(randomNumbers[i]);
        }
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


    public static class ParticipatingCars {

        private final List<Car> participatingCars;

        public ParticipatingCars(String inputNames) {
            participatingCars = new ArrayList<>();
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

        public List<Car> winners() {
            List<Car> winners = new ArrayList<>();
            Position max = max();
            for (Car car : this.participatingCars) {
                if (car.equalPosition(max)) {
                    winners.add(car);
                }
            }
            return winners;
        }

        private Position max() {
            Position max = new Position(0);
            for (Car car : this.participatingCars) {
                if (car.isForward(max)) {
                    max = new Position(car.position().position());
                }
            }
            return max;
        }
    }
}
