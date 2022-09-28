package ThirdStep.view;

import ThirdStep.domain.model.request.CarRequest;
import ThirdStep.domain.model.request.SettingRequest;
import ThirdStep.view.utils.TextPrintUtils;
import ThirdStep.view.utils.UserInputScanUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class UserInputView {
    private static final String CAR_NAME_REGEX = ",";

    public SettingRequest generateSettingRequest() {
        String carNameInput = requestCarNames();
        int racingRoundCountInput = requestRoundCount();

        return new SettingRequest(
                Arrays.stream(carNameInput.split(CAR_NAME_REGEX))
                        .map(CarRequest::new)
                        .collect(Collectors.toList()),
                racingRoundCountInput);
    }

    private String requestCarNames() {
        TextPrintUtils.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        return UserInputScanUtils.stringScan();
    }

    private int requestRoundCount() {
        TextPrintUtils.println("시도할 회수는 몇 회 인가요?");
        return UserInputScanUtils.intScan();
    }
}
