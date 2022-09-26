package ThirdStep;

import ThirdStep.model.Car;
import ThirdStep.model.CarRequest;
import ThirdStep.model.GameSetting;
import ThirdStep.validator.RequestValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameSetter {

    private GameSetting gameSetting;
    private static final String CAR_NAME_REGEX = ",";

    public GameSetting getGameSetting() {
        return gameSetting;
    }

    public void setting() {
        TextPrinter.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String carNameInput = UserInputScanner.stringScan();

        List<CarRequest> carRequests = Arrays
                .stream(carNameInput.split(CAR_NAME_REGEX))
                .map(CarRequest::new)
                .collect(Collectors.toList());

        carRequests.forEach(RequestValidator::carValidation);

        TextPrinter.print("시도할 회수는 몇 회 인가요?");
        int attempts = UserInputScanner.intScan();

        gameSetting = new GameSetting();
        gameSetting.setAttempts(attempts);
        gameSetting.setCars(carRequests.stream().map(Car::of).collect(Collectors.toList()));
    }
}
