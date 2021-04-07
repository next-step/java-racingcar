package RacingGame.domain;

import RacingGame.dto.CarDto;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;
    private Rule rule = new DefaultRule();

    public Cars() {
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Integer> locations(){
        return cars.stream()
                .map(car -> car.isAt())
                .collect(Collectors.toList());
    }

    public void playGame(){
        cars.forEach(car -> car.move(rule));
    }

    public List<CarDto> getCarDtos(){
        return cars.stream()
                .map(car -> car.getCarDto())
                .collect(Collectors.toList());
    }

    public List<String> getWinners(){
        Integer maxLocation = getMaxLocation(cars);
        return namesOfWinner(maxLocation,cars);

    }

    public List<String> namesOfWinner(Integer maxLocation, List<Car> racingCars){

        return cars.stream()
                .filter(car -> car.isAt() == maxLocation )
                .map(car -> car.carName())
                .collect(Collectors.toList());
    }

    public Integer getMaxLocation(List<Car> racingCars) {
        return racingCars.stream()
                .map(car -> car.isAt())
                .max(Comparator.comparing(x -> x))
                .orElseThrow(NoSuchElementException::new);
    }

}
