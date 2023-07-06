package car.domain.model;

import car.exceptions.TextLengthException;

public class CarName {

    private final static int TEXT_LENGTH_LIMIT = 5;
    private final String myCarName;

    public CarName(final String eachCarName) {
        validateNameLength(eachCarName);
        this.myCarName = eachCarName;
    }

    /**
     * @param carName
     * @throws TextLengthException :
     */
    private void validateNameLength(final String carName) {
        if (carName.length() > TEXT_LENGTH_LIMIT) {
            throw new TextLengthException(TEXT_LENGTH_LIMIT, " 글자 아래로 작성해 주세요.");
        }
    }

    public String getMyCarName() {
        return myCarName;
    }

}
