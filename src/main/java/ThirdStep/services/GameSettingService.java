package ThirdStep.services;

import ThirdStep.model.Car;
import ThirdStep.model.CarRequest;
import ThirdStep.model.GameSetting;
import ThirdStep.utils.TextPrintUtils;
import ThirdStep.utils.UserInputScanUtils;

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

        TextPrintUtils.println("시도할 회수는 몇 회 인가요?");
        int attempts = UserInputScanUtils.intScan();

        List<CarRequest> carRequests = generateCarRequest(carNameInput);

        gameSetting = new GameSetting(attempts, carRequests.stream().map(Car::new).collect(Collectors.toList()));
    }

    private static List<CarRequest> generateCarRequest(String carNameInput) {
        return Arrays
                .stream(carNameInput.split(CAR_NAME_REGEX))
                .map(CarRequest::new)
                .collect(Collectors.toList());
    }
}
