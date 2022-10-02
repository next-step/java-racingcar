package racing.domain.model;

import calculator.util.StringUtil;

public class CarName
{
    private static final int MAX_SIZE = 5;
    private final String carName;

    private CarName(String carName)
    {
        validateCarName(carName);
        this.carName = carName;
    }

    public static CarName from(String carName)
    {
        return new CarName(carName);
    }

    public String getCarName()
    {
        return carName;
    }

    private void validateCarName(String carName)
    {
        validateSize(carName);
        validateNullOrEmpty(carName);
    }

    private void validateSize(String carName)
    {
        if (carName.length() > MAX_SIZE)
        {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 엇습니다.");
        }
    }
    private void validateNullOrEmpty(String carName)
    {
        if (StringUtil.isNullOrEmpty(carName))
        {
            throw new IllegalArgumentException("자동차 이름은 null 이거나 빈값 일 수 없습니다.");
        }
    }
}
