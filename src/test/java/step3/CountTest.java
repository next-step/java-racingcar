package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountTest {

    private Count count;

    @BeforeEach
    public void createCount() {
        count = new Count();
    }
    
    @Test
    @DisplayName("Count 인자없는 생성자로 객체 생성시 0이 디폴트이다.")
    public void createDefault() {

        Assertions.assertThat(count).isEqualTo(new Count(0));
    }

}