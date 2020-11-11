package racing.model;

import racing.Racing;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCars {
    private List<Car> cars = new LinkedList<>();
    private static final String CANDIDATE_DELIMITER = ",";
    private static final int RANDOM_RANGE = 10;
    private Random random = new Random();

    public RacingCars(String candidateList){
        String[] candidates = candidateList.split(CANDIDATE_DELIMITER);
        if(candidates.length <= 1){
            throw new IllegalArgumentException("경기에 참여하는 인원은 1명일 수 없습니다.");
        }

        Arrays.stream(candidates).forEach(candidate -> cars.add(new RacingCar(candidate)));
    }

    public RacingCars(List<Car> cars){
        this.cars = cars;
    }

    public List<Car> getCandidates(){
        return cars;
    }

    public void racing(){
        cars.forEach(car -> car.move(getRandomFuel()));
    }

    public List<String> getWinners(){
        int maxLocation = cars.stream().map(Car::currentLocation).max(Comparator.naturalOrder()).orElse(0);
        return cars.stream().filter(car -> car.currentLocation() == maxLocation).map(Car::getCarName).collect(Collectors.toList());
    }

    private int getRandomFuel(){
        return random.nextInt(RANDOM_RANGE);
    }


}
