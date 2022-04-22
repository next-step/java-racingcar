package domain;

public class Race {
    public RaceRecord start(String carsName, int raceTryCount) {
        if (!validateCarsName(carsName)) {
            throw new IllegalArgumentException("자동차 대수는 1대 이상이어야 경주 할 수 있습니다.");
        }

        return new RunRace().run(carsName, raceTryCount);
    }

    private boolean validateCarsName(String carsName) {
        return carsName != null && !carsName.isBlank() && carsName.length() > 0;
    }

}
