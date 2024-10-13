package racinggame.generator;

import java.util.ArrayList;
import java.util.List;
import racinggame.dto.CarDto;

public class CarDtoTestGenerator {

    public static List<CarDto> carDtos(int... positions) {
        ArrayList<CarDto> result = new ArrayList<>();
        for (int position : positions) {
            result.add(new CarDto(position));
        }
        return result;
    }

}
