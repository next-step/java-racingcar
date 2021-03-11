package step3.study.domain;

import step3.study.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCarList() {
        return cars;
    }

    public List<String> moveCars(RandomGenerator randomGenerator) {
        List<String> recodeDistance = new ArrayList<>();
        for (Car car : cars) {
            recodeDistance.add(car.move(randomGenerator.getRandomNumber()));
        }
        return recodeDistance;
    }

    public ResponseRacingDTO moveCarsForTryCount(RequestRacingDTO requestRacingDTO, RandomGenerator randomGenerator) {
        int tryCount = requestRacingDTO.getTryCount();
        List<Recodes> recodeList = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            recodeList.add(new Recodes(moveCars(randomGenerator)));
        }
        return new ResponseRacingDTO(recodeList);
    }

    public static List<Car> of(RequestRacingDTO requestRacingDTO) {
        int carCount = requestRacingDTO.getCarCount();

        return IntStream.range(0, carCount)
                .mapToObj(index -> new Car())
                .collect(Collectors.toList());
    }

}
