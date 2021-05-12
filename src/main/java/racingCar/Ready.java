package racingCar;

public class Ready {
    private static final String SPLIT_VALUE = ",";

    public String[] splitNameByComma(String carName) {
        return carName.split(SPLIT_VALUE);
    }

    public boolean isGreaterThanFive(int number) {
        return number > 5;
    }

    public String checkNameLength(String carName) {
        if (isGreaterThanFive(carName.length())) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5를 초과합니다.");
        }
        return carName;
    }

     public String[] MakeParticipantListByName(String carName) {
        String[] nameList = splitNameByComma(carName);

        for (int i = 0; i < nameList.length; i++) {
            nameList[i] = checkNameLength(nameList[i]);
        }
        return nameList;
    }
}
