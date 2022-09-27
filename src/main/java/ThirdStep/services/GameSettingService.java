package ThirdStep.services;

import ThirdStep.model.Car;
import ThirdStep.model.CarRequest;
import ThirdStep.model.GameSetting;
import ThirdStep.utils.TextPrintUtils;
import ThirdStep.utils.UserInputScanUtils;
import ThirdStep.validator.RequestValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameSettingService {

    private GameSetting gameSetting;
    private static final String CAR_NAME_REGEX = ",";

    public GameSetting getGameSetting() {
        return gameSetting;
    }

    public void setting() {
        TextPrintUtils.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String carNameInput = UserInputScanUtils.stringScan();

        List<CarRequest> carRequests = Arrays
                .stream(carNameInput.split(CAR_NAME_REGEX))
                .map(CarRequest::new)
                .collect(Collectors.toList());

        carRequests.forEach(RequestValidator::carValidation);

        TextPrintUtils.println("시도할 회수는 몇 회 인가요?");
        int attempts = UserInputScanUtils.intScan();


        // 모델 내에서 검증을 해라고??
        gameSetting = new GameSetting();
        gameSetting.setAttempts(attempts);
        gameSetting.setCars(carRequests.stream().map(Car::of).collect(Collectors.toList()));
    }
}
