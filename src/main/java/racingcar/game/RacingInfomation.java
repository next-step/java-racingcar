package racingcar.game;

import racingcar.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingInfomation {
    private static final String DELIMETER = ",";
    private final int numberOfCar;
    private final int playCount;
    private final List<String> carNames;

    private RacingInfomation(Builder builder) {
        numberOfCar = builder.numberOfCar;
        playCount = builder.playCount;
        carNames = builder.carNames;
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public int getPlayCount() {
        return playCount;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public static class Builder{
        private final int playCount;

        private int numberOfCar = 0;
        private List<String> carNames = new ArrayList<>();

        public Builder(int playCount) {
            this.playCount = playCount;
        }

        public Builder numberOfCar(int value) {
            numberOfCar = value;
            return this;
        }

        public Builder carNames(String value) {
            carNames = Stream.of(value.split(DELIMETER))
                    .map(String::trim)
                    .collect(Collectors.toList());
            isValidCarNames(carNames);
            return this;
        }

        public RacingInfomation build(){
            return new RacingInfomation(this);
        }

        private void isValidCarNames(List<String> names) {
            names.forEach(name->{
                if (name.length() > 5) {
                    throw new IllegalArgumentException(Constant.ERROR_5OVER_NAME);
                }
            });
        }
    }

}
