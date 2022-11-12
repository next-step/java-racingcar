package dto;

public class CarDto {

    private static final String RESULT_SEPARATOR = " : ";
    private static final String POSITION_INDICATOR = "-";
    private final String carName;
    private final int position;

    public CarDto(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }

    public String getResultString() {
        StringBuilder resultSb = new StringBuilder();
        resultSb.append(this.carName)
            .append(RESULT_SEPARATOR)
            .append(POSITION_INDICATOR.repeat(this.position));

        return resultSb.toString();
    }
}
