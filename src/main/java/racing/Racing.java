package racing;

import racing.car.Car;
import racing.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    private static final Random random = new Random();
    private ParticipatingCars participatingCars;
    private int attemptCount;

    public static List<Car> enroll(String names) {
        String[] enrolledList = names.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : enrolledList) {
            cars.add(new Car(name, 0));
        }
        return cars;
    }

    public Racing(List<Car> cars, int attemptCount) {
        this.participatingCars = new ParticipatingCars();
        for (Car car : cars) {
            this.participatingCars.join(car);
        }
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
        List<Car> winners = new ArrayList<>();
        int position = 0;
        for (Car car : this.participatingCars()) {
            if (position == car.position().position()) {
                winners.add(car);
            }
            if (position < car.position().position()) {
                winners.clear();
                winners.add(car);
                position = car.position().position();
            }
        }
        return winners;
    }

    /**
     * 대회를 시작한다.
     */
    public void start() {
        for (int i = 0; i < attemptCount; ++i) {
            attemptGo();
        }
    }

    private void attemptGo() {
        for (Car car : this.participatingCars()) {
            int input = random.nextInt(10);
            car.move(input);
            ResultView.showCurrentPosition(car);
        }
        System.out.println();
    }
}
