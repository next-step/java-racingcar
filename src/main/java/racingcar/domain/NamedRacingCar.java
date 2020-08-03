package racingcar.domain;

import java.util.regex.Pattern;

import static racingcar.domain.RacingResult.namedResult;

class NamedRacingCar implements RacingCar {

    public static final int MAX_NAME_LEN = 5;
    public static final String ERROR_MSG_CAR_NAME = "자동차 이름은 5자 이하이며, 영어 소문자(a-z)로 시작하고, 숫자를 포함할 수 있습니다.";
    private static final Pattern namePattern = Pattern.compile("[a-z][a-z0-9]{0,4}");

    private final IncreaseMileageRacingCar racingCar;
    private final String name;

    NamedRacingCar(String name) {
        requiredName(name);
        this.name = name;
        this.racingCar = new IncreaseMileageRacingCar();
    }

    private void requiredName(String name) {
        if( null == name || !namePattern.matcher(name).matches() ){
            throw new IllegalArgumentException(ERROR_MSG_CAR_NAME);
        }
    }

    @Override
    public void racing(MotorRacingRule motorRacingRule) {
        racingCar.racing(motorRacingRule);
    }

    @Override
    public RacingResult getResult() {
        return namedResult(name, racingCar.getMileage());
    }
}
