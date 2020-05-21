package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private InputView inputView= null;

    @BeforeEach
    public void setUp(){
        inputView = new InputView();
    }
}