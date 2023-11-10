package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveCarStatusTest {

    @Test
    public void moveCarStatusTest() {
        MoveCarStatus moveCarStatus = new MoveCarStatus(CarName.splitCarNames("abc,def,hig,lmn"), 0);
        assertThat(moveCarStatus.getCars()).hasSize(4);
        assertThat(moveCarStatus.getCars().get(0).name()).isEqualTo("abc");
        assertThat(moveCarStatus.getCars().get(1).name()).isEqualTo("def");
        assertThat(moveCarStatus.getCars().get(2).name()).isEqualTo("hig");
        assertThat(moveCarStatus.getCars().get(3).name()).isEqualTo("lmn");
    }

}