package racingcar.model;

public class CarRecord {
    private String dashCharacterString;

    public CarRecord(int movingDistance) {
        dashCharacterString = changeMovingDistanceToDashCharacter(movingDistance).toString();
    }

    private StringBuilder changeMovingDistanceToDashCharacter(int carMovingDistance) {
        StringBuilder dashCharacterString = new StringBuilder();

        for(int i = 0; i < carMovingDistance; i++) {
            dashCharacterString.append("-");
        }

        return dashCharacterString;
    }

    public String getDashCharacterString() {
        return dashCharacterString;
    }
}
