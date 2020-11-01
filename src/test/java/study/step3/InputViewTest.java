package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    private TestingInputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new TestingInputView();
    }

    @Test
    @DisplayName("request() 은 입력 결과를 응답한다.")
    public void request() {
        inputView.setConsoleInput("red");

        Circuit circuit = inputView.request();
        assertThat(circuit).isNotNull();
    }

    @Test
    @DisplayName("입력결과가 없으면 오류메시지를 출력한다.")
    public void whenCarNamesIsEmpty() {
        inputView.setConsoleInput("");

        inputView.request();

        assertThat(inputView.recentErrorMessage()).isEqualTo("쉼표로 구분된 자동차 이름을 입력해주세요.");
    }

    @Test
    @DisplayName("자동차 이름이 5자가 넘으면 오류메시지를 출력한다.")
    public void whenCarNameOverFiveChar() {
        inputView.setConsoleInput("yellow");

        inputView.request();

        assertThat(inputView.recentErrorMessage()).isEqualTo("이름은 5자를 넘을 수 없습니다.");
    }

    @Test
    @DisplayName("쉽표로 구분된 입력을 분석하여 자동차 객체로 반환한다.")
    public void parsingCarNames() {
        inputView.setConsoleInput("red,gold,white,blue");

        Circuit circuit = inputView.request();

        //@formatter:off
        assertThat(circuit.getCars())
                .hasSize(4)
                .containsExactlyInAnyOrder(
                        new RealCar("red"),
                        new RealCar("gold"),
                        new RealCar("white"),
                        new RealCar("blue"));
        //@formatter:on
    }

    @Test
    @DisplayName("횟수를 입력받는다")
    public void stepCount() {
        inputView.setConsoleInput("4");

        Circuit circuit = inputView.request();

        assertThat(circuit.getLaps()) //
                .isEqualTo(4);
    }

    private static class TestingInputView extends InputView {
        private Queue<String> consoleInput = new ArrayDeque<>();
        private String errorMessage;

        public void setConsoleInput(String input) {
            consoleInput.add(input);
        }

        public String recentErrorMessage() {
            return errorMessage;
        }

        @Override
        protected String nextLine() {
            return consoleInput.poll();
        }

        @Override
        protected void printError(String message) {
            this.errorMessage = message;
        }
    }

    private static class InputView {
        public Circuit request() {
            String names = requestNames();

            Set<Car> cars = Arrays.stream(names.split(",")) //
                    .map(RealCar::new) //
                    .collect(toSet());

            return new Circuit(cars);
        }

        private String requestNames() {
            String names = nextLine();
            if (names.isEmpty()) {
                printError("쉼표로 구분된 자동차 이름을 입력해주세요.");
            }
            if (names.length() > 5) {
                printError("이름은 5자를 넘을 수 없습니다.");
            }

            return names;
        }

        protected void printError(String message) {

        }

        protected String nextLine() {
            return null;
        }

    }

    private static class Circuit {
        private final Set<Car> cars;

        public Circuit(Set<Car> cars) {
            this.cars = cars;
        }

        public Set<Car> getCars() {
            return cars;
        }
    }
}
