package step2;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

        ValidationCheck vCheck = new ValidationCheck();

        @BeforeEach
        void setUp(){
            System.out.println("!! SetUp !! ");
        }

        @DisplayName("0이 아닌 양수가 입력되었는지 확인")
        @Test
        void inputZeroTest(){
            assertThatIllegalArgumentException().isThrownBy(() -> vCheck.checkInputZero(0, 0));
        }

        @AfterEach
        void tearDown() {
            System.out.println("tearDown");
        }
    }
