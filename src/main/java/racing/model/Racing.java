package racing.model;

import java.util.*;


public class Racing {

    private static final String CANDIDATE_DELIMITER = ",";
    private static final int RANDOM_RANGE = 10;

    private List<Car> cars = new LinkedList<>();
    private Random random = new Random();

    public Racing(String candidateList) {
        String[] candidates = candidateList.split(CANDIDATE_DELIMITER);
        if (candidates.length <= 1) {
            throw new IllegalArgumentException("경기에 참여하는 인원은 1명일 수 없습니다.");
        }

        Arrays.stream(candidates).forEach(candidate -> cars.add(new RacingCar(candidate)));
    }

    public Racing(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCandidates() {
        return cars;
    }


    public void racing() {
        cars.forEach(car -> car.move(getRandomFuel()));
    }

    private int getRandomFuel() {
        return random.nextInt(RANDOM_RANGE);
    }
}
