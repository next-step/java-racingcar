package racingGame.Business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProcessTest {
    
    Process gp;
    
    @BeforeEach
    void setUp() {
        gp = new Process();
    }
    
    @Test
    void carGenerateResultNullTest() {
        assertThatThrownBy(() -> {
            gp.run(-1,1);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("%s","참가시킬 자동차 수가 음수");
    }

    @Test
    void gameTurnSetNullTest() {
        assertThatThrownBy(() -> {
            gp.run(1,-1);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("몇번의 게임을 할지 값을 입력해주세요 ");
    }

    @Test
    void carGenerateResultTest() {
        gp.run(3,1);
        assertThat(gp.joinCars().size).isEqual(3);
    }

    @Test
    void gameNextTurnTest() {
        gp.run(1,2);
        assertThat(gp.nowTurn()).isEqual(2);
    }

    @Test
    void carForwardTest() {
        gp.run(1, 10);
        while(true) {
            gp.nextTurn();
            if(gp.joinCars.get(0).loaction > 0) {
                break;
            }
        }

        assertThat(gp.joinCars.get(0).loaction).isNotEqual(0);
    }

    @Test
    void carsForwardTest() {
        gp.run(3, 10);
        while(true) {
            gp.nextTurn();
            if(gp.joinCars.get(0).loaction > 2) {
                break;
            }
        }
        for(Car car : gp.joinCars){
            assertThat(car.loaction).isNotEqual(0);
        }
    }
}