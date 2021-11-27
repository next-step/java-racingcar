package racingcar.vo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsDto {
    private final List<CarDto> cars;

    public CarsDto(String[] names) {
        this.cars = Arrays.stream(names).map(CarDto::new).collect(Collectors.toList());
    }

    public CarsDto(List<CarDto> cars) {
        this.cars = cars;
    }

    public List<CarDto> getList() {
        return this.cars;
    }

    public int getSize() {
        return this.cars.size();
    }

    public CarDto getCarDto(int index) {
        return this.cars.get(index);
    }
}
