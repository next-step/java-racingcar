package step3;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    InputView inputView;

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.readInput();
        assertThat(inputView.getCarNumber()).isEqualTo(2);
        assertThat(inputView.getTryCount()).isEqualTo(3);
    }

}