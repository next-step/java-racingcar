package step3;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.*;

class OilTankTest {
    
    @ParameterizedTest(name = "[{index}] oils = {0}")
    @NullSource
    void createWithNullAndEmpty_ThrownException(List<Oil> oils) throws Exception {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> OilTank.fill(oils))
                .withMessage("oils is required");
    }

    @Test
    void useOilWhenOilIsEmpty_thrownException() throws Exception {
        //given
        OilTank emptyOilTank = OilTank.fill(emptyList());

        //when
        ThrowingCallable useOil = emptyOilTank::use;

        //then
        assertThatIllegalStateException()
                .isThrownBy(useOil)
                .withMessage("oilTank is empty.");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "GOOD, SUFFICIENT",
            "BAD, INSUFFICIENT",
    })
    void useOilTankTest(Oil oil, Power expectedPower) throws Exception {
        OilTank oilTankFilledWithGoodOil = OilTank.fill(singletonList(oil));

        Power resultPower = oilTankFilledWithGoodOil.use();

        assertThat(resultPower).isEqualTo(expectedPower);
    }

}
