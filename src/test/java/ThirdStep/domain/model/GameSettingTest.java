package ThirdStep.domain.model;

import ThirdStep.domain.model.request.SettingRequest;
import ThirdStep.view.UserInputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class GameSettingTest {
    private final static String CAR_NAMES_INPUT = "robin,kaya,julie";
    private final static String[] CAR_NAMES = CAR_NAMES_INPUT.split(",");
    private final static int CAR_COUNT = 3;
    private final static int ATTEMPTS = 5;

    private final UserInputView userInputView = new UserInputView();

    private static SettingRequest settingRequest;

    @BeforeEach
    void initInput() {
        InputStream settings = new ByteArrayInputStream(String.format("%s\n%d", CAR_NAMES_INPUT, ATTEMPTS).getBytes());
        System.setIn(settings);

        settingRequest = userInputView.generateSettingRequest();
    }

    @Test
    @DisplayName("입력된 자동차 이름 개수와 동일한 수의 Car를 생성한다.")
    void 자동차_생성_테스트() {
        GameSetting gameSetting = new GameSetting(settingRequest);
        List<Car> cars = gameSetting.getCars();

        assertThat(cars.size()).isEqualTo(CAR_COUNT);
    }

    @Test
    @DisplayName("입력된 자동차 이름을 가지는 Car를 생성한다.")
    void 자동차_생성_이름_테스트() {
        GameSetting gameSetting = new GameSetting(settingRequest);
        List<Car> cars = gameSetting.getCars();

        List<String> carNames = cars.stream().map(Car::getName).collect(Collectors.toList());
        assertThat(carNames).contains(CAR_NAMES);
    }

}
