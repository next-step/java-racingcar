package racingGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIterable;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class GameProcessTest {
    
    @Test
    void carGenerateResultNullTest() {
        Gameprocess gp = new Gameprocess();
        assertThatThrownBy(() -> {
            gp.generateCar(-1);
        }).isInstanceOf(RuntimeException.class)
            .hasMessage("참가시킬 자동차 수가 없습니다.");
    }
    
    @Test
    void gameTurnSetNullTest() {
        Gameprocess gp = new Gameprocess();
        assertThatThrownBy(() -> {
            gp.setGameTurn(-1);
        }).isInstanceOf(RuntimeException.class)
            .hasMessage("몇번의 게임을 할지 값을 입력해주세요 ");
    }
    
    @Test
    void carGenerateResultTest() {
        Gameprocess gp = new Gameprocess();
        gp.generateCar(3);
        assertThat(gp.joinCars().size).isEqual(3);
    }
    
    @Test
    void gameNextTurnTest() {
        Gameprocess gp = new Gameprocess();
        gp.generateCar(1);
        gp.nextTurn();
        gp.nextTurn();
        assertThat(gp.nowTurn()).isEqual(2);
    }
    
    @Test
    void carForwardTest() {
        Gameprocess gp = new Gameprocess();
        gp.generateCar(1);
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
        Gameprocess gp = new Gameprocess();
        gp.generateCar(3);
        while(true) {
            gp.nextTurn();
            if(gp.joinCars.get(0).loaction > 2) {
                break;
            }
        }
        for(car : gp.joinCars){
            assertThat(car.loaction).isNotEqual(0);
        }

    }

}