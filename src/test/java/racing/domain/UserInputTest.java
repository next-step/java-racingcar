package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class UserInputTest {
    @Test
    void 이름_나눠지는_것_테스트() {
        String test = "tom, john,james, lina , julia";
        assertThat(UserInput.splitStringByComma(test)).contains("tom", "john", "james", "lina", "julia");
    }

    @Test
    void 이름_길이_체크_실패() {
        try {
            String name = "123456";
            UserInput.checkNameLength(name);

            fail();
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    @Test
    void 이름_길이_체크_성공() {
        try {
            String name = "12345";
            UserInput.checkNameLength(name);
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    void 자동차_개수_체크_실패() {
        try {
            List<String> nameList = Arrays.asList();
            UserInput.checkCarCount(nameList);

            fail();
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    @Test
    void 자동차_개수_체크_성공() {
        try {
            List<String> nameList1 = Arrays.asList("1");
            UserInput.checkCarCount(nameList1);

            List<String> nameList2 = Arrays.asList("1", "2");
            UserInput.checkCarCount(nameList2);
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    void 시도횟수_체크_실패() {
        try {
            int tryNumber = 0;
            UserInput.checkTryNumber(tryNumber);

            fail();
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    @Test
    void 시도횟수_체크_성공() {
        try {
            int tryNumber = 1;
            UserInput.checkTryNumber(tryNumber);
        } catch (IllegalArgumentException e) {
            fail();
        }
    }
}