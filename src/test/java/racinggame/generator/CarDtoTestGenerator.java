package racinggame.generator;

import java.util.ArrayList;
import java.util.List;
import racinggame.dto.CarDto;

public class CarDtoTestGenerator {

    public static List<CarDto> carDtos(List<Integer> positions, List<String> names) {
        ArrayList<CarDto> result = new ArrayList<>();
        for (int i = 0; i < positions.size(); i++) {
            result.add(new CarDto(positions.get(i), names.get(i)));
        }
        return result;
    }

}
