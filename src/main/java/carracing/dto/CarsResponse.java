package carracing.dto;

import carracing.Cars;

public class CarsResponse {
    private static final String POSTION_STRING = "-";
    private static final String CAR_SEPARATOR = "\n";
    public static final String NAME_POSITION_SEPARATOR = " : ";

    private final String carsInfo;

    public CarsResponse(String carsInfo) {
        this.carsInfo = carsInfo;
    }

    public static CarsResponse from(Cars cars) {
        StringBuffer sb = new StringBuffer();
        cars.getCars().forEach(car -> {
            sb.append(car.getName());
            sb.append(NAME_POSITION_SEPARATOR);
            sb.append(POSTION_STRING.repeat(car.getPosition()));
            sb.append(CAR_SEPARATOR);
        });
        return new CarsResponse(sb.toString());
    }

    public String getCarsInfo() {
        return carsInfo;
    }
}
