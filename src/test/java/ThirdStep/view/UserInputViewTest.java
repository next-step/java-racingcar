package ThirdStep.view;

import ThirdStep.domain.model.request.SettingRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class UserInputViewTest {

    private final static String CAR_NAMES_INPUT = "robin,kaya,julie";
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
    @DisplayName("게임에 참여할 자동차 수와 시도 회수를 입력받고 저장할 수 있다.")
    void 경기_셋팅_테스트() {
        assertThat(settingRequest.getCarRequests().size()).isEqualTo(3);
        assertThat(settingRequest.getAttempts()).isEqualTo(5);
    }


}
