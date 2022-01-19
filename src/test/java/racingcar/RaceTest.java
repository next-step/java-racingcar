package racingcar;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {
    @DisplayName("0~9사이의 정수를 반환하는지 100번 확인한다.")
    @Test
    public void printRandomNumberTenTimes(){
        Race race = new Race();
        int[] check = new int[10];
        for(int i=0; i<100; i++) {
            int randomNumber = race.getRandomNumber();
            System.out.println(randomNumber);
            check[randomNumber]++;
        }
        int sum = 0;
        for(int i=0; i<10; i++){
            sum+=check[i];
        }
        assertThat(sum).isEqualTo(100);
    }
}