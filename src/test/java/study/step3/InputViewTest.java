package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InputViewTest {

    private TestingInputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new TestingInputView();
    }

    @Test
    @DisplayName("request() 은 입력 결과를 응답한다.")
    public void request() {
        inputView.setConsoleInput("red", "1");

        Circuit circuit = inputView.request();
        assertThat(circuit).isNotNull();
    }

    @Test
    @DisplayName("입력결과가 없으면 오류메시지를 출력한다.")
    public void whenCarNamesIsEmpty() {
        inputView.setConsoleInput("", "1");

        inputView.request();

        assertThat(inputView.recentErrorMessage()).isEqualTo("쉼표로 구분된 자동차 이름을 입력해주세요.");
    }

    @Test
    @DisplayName("자동차 이름이 5자가 넘으면 오류메시지를 출력한다.")
    public void whenCarNameOverFiveChar() {
        inputView.setConsoleInput("yellow", "1");

        inputView.request();

        assertThat(inputView.recentErrorMessage()).isEqualTo("이름은 5자를 넘을 수 없습니다.");
    }

    @Test
    @DisplayName("쉽표로 구분된 입력을 분석하여 자동차 객체로 반환한다.")
    public void parsingCarNames() {
        inputView.setConsoleInput("red,gold,white,blue", "1");

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
    @DisplayName("쉽표로 구분된 입력을 분석하여 자동차 객체로 반환한다.")
    public void CarNameOverFiveCharInList() {
        inputView.setConsoleInput("red,gold,yellow,blue", "1");

        inputView.request();

        assertThat(inputView.recentErrorMessage()).isEqualTo("이름은 5자를 넘을 수 없습니다.");
    }

    @Test
    @DisplayName("횟수를 입력받는다")
    public void requestLaps() {
        inputView.setConsoleInput("red", "4");

        Circuit circuit = inputView.request();

        assertThat(circuit.getLaps()) //
                .isEqualTo(4);
    }

    @Test
    @DisplayName("횟수는 Integer type 이어야 한다.")
    public void ensureLapsType() {
        inputView.setConsoleInput("red", "A");

        assertThatExceptionOfType(NumberFormatException.class) //
                .isThrownBy(() -> inputView.request());

        assertThat(inputView.recentErrorMessage()).isEqualTo("횟수는 0 이상의 정수로 입력해 주세요.");
    }

    @Test
    @DisplayName("횟수는 0 이상이어야 한다.")
    public void ensureLapsMinValue() {
        inputView.setConsoleInput("red", "-1");

        inputView.request();

        assertThat(inputView.recentErrorMessage()).isEqualTo("횟수는 0 이상의 정수로 입력해 주세요.");
    }

    private static class TestingInputView extends InputView {
        private final Queue<String> consoleInput = new ArrayDeque<>();
        private String errorMessage;

        public void setConsoleInput(String name, String laps) {
            consoleInput.add(name);
            consoleInput.add(laps);
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

            int laps = requestLaps();
            return new Circuit(cars, laps);
        }

        private int requestLaps() {
            String laps = nextLine();
            if (!isInteger(laps)) {
                printError("횟수는 0 이상의 정수로 입력해 주세요.");
            }
            int lapsAsInteger = Integer.parseInt(laps);
            if (lapsAsInteger < 1) {
                printError("횟수는 0 이상의 정수로 입력해 주세요.");
            }

            return lapsAsInteger;
        }

        private boolean isInteger(String input) {
            try {
                Integer.parseInt(input);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
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
        private final int laps;

        public Circuit(Set<Car> cars, int laps) {
            this.cars = cars;
            this.laps = laps;
        }

        public Set<Car> getCars() {
            return cars;
        }

        public int getLaps() {
            return laps;
        }
    }
}
