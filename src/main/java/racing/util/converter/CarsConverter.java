package racing.util.converter;

import racing.domain.car.Car;
import racing.domain.car.Cars;
import racing.domain.Name;
import racing.exception.InvalidInputException;
import util.StringUtils;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CarsConverter implements Converter<String, Cars> {
    private static final Function<Name, Car> DEFAULT_CAR_CTOR = Car::new;
    private static final String NAME_DELIMITER = ",";

    @Override
    public Cars convert(String input) {
        validate(input);

        String[] strNameSplitValues = input.split(NAME_DELIMITER);

        return new Cars(
                Arrays.stream(strNameSplitValues)
                        .map(Name::new)
                        .map(DEFAULT_CAR_CTOR)
                        .collect(Collectors.toSet())
        );
    }

    private void validate(String input) {
        if (StringUtils.isEmpty(input))
            throw new InvalidInputException("자동차를 입력 해주세요.");
    }

    public static CarsConverter getInstance() {
        return InnerClazz.instance;
    }

    private static class InnerClazz {
        public static final CarsConverter instance = new CarsConverter();
    }
}
