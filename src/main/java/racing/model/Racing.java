package racing.model;

import java.util.*;


public class Racing {

    private static final String CANDIDATE_DELIMITER = ",";
    private static final int RANDOM_RANGE = 10;
    private static final int MIN_CANDIDATE = 1;

    private List<Car> cars = new LinkedList<>();
    private Random random = new Random();

    public Racing(String candidateList) {
        String[] candidates = candidateList.split(CANDIDATE_DELIMITER);

        if (isValid(candidates.length)) {
            throw new IllegalArgumentException(String.format("경기에 참여하는 인원은 %d명 이하일 수 없습니다.", MIN_CANDIDATE));
        }

        Arrays.stream(candidates).forEach(candidate -> cars.add(new RacingCar(candidate)));
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

    private boolean isValid(int candidateCount){
        return candidateCount <= MIN_CANDIDATE;
    }
}
