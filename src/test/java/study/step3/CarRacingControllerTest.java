package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.CarRacing;
import study.step3.domain.Circuit;
import study.step3.view.InputView;
import study.step3.view.ResultView;

import static java.util.Collections.emptySet;
import static org.assertj.core.api.Assertions.assertThat;

class CarRacingControllerTest {

    private CarRacingController carRacingController;
    private Circuit circuit;
    private CarRacing mockCarRacing;
    private ResultView mockResultView;
    private InputView mockInputView;

    @BeforeEach
    void setUp() {
        circuit = new Circuit(emptySet(), 1);
        mockInputView = mockInputView();
        mockCarRacing = mockCarRacing();
        mockResultView = mockResultView();
        carRacingController = new TestingCarRacingController(mockInputView, mockCarRacing, mockResultView);
    }

    @Test
    @DisplayName("컨트롤러는 내부 객체와 상호작용을 한다.")
    void interact() {
        carRacingController.invoke();

        assertThat(mockInputView).extracting("interacted").containsExactly(true);
        assertThat(mockCarRacing).extracting("interacted").containsExactly(true);
        assertThat(mockResultView).extracting("interacted").containsExactly(true);
    }

    private static class TestingCarRacingController extends CarRacingController {
        private final CarRacing mockCarRacing;
        private final ResultView mockResultView;

        private final InputView mockInputView;

        public TestingCarRacingController(InputView mockInputView, CarRacing mockCarRacing, ResultView mockResultView) {
            this.mockCarRacing = mockCarRacing;
            this.mockResultView = mockResultView;
            this.mockInputView = mockInputView;
        }

        @Override
        protected CarRacing makeRacing(Circuit request) {
            return mockCarRacing;
        }

        @Override
        protected InputView makeInputView() {
            return mockInputView;
        }

        @Override
        protected ResultView makeResultView(CarRacing carRacing) {
            return mockResultView;
        }

    }

    private InputView mockInputView() {
        return new InputView() {
            private boolean interacted;

            @Override
            public Circuit request() {
                interacted = true;

                return circuit;
            }
        };
    }

    private ResultView mockResultView() {
        return new ResultView(mockCarRacing) {
            private boolean interacted;

            @Override
            public void report() {
                interacted = true;
            }
        };
    }

    private CarRacing mockCarRacing() {
        return new CarRacing(circuit) {
            private boolean interacted;

            @Override
            public void start() {
                interacted = true;
            }
        };
    }
}
