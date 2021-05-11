package racingCar;

public class Ready {
    private static final String SPLIT_VALUE = ",";

    public String[] splitNameByComma(String carName) {
        return carName.split(SPLIT_VALUE);
    }

    public boolean isGreaterThanFive(String carName) {
        return carName.length() > 5;
    }
/*
    public String[] MakeParticipantListByName(String carName) {
        Input input = new Input();

        try (isGreaterThanFive(carName)) {
            String tryCarName = input.carName();
            System.out.println(tryCarName);
            return splitNameByComma(carName);
        }
    }

 */
}
