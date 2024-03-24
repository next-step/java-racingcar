package study;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;


public class AssertJTest {


    @Test
    void ObjectAssertionTest() {
        class Dog {
            protected Dog(String name, Float weight) {
                this.name = name;
                this.weight = weight;
            }

            private final String name;
            private final Float weight;

            // standard getters and setters
        }

        Dog fido = new Dog("Fido", 5.25f);
        Dog fidosClone = new Dog("Fido", 5.25f);
//         equals 오버라이딩 안하면 객체 참조 -> 실패
//        assertThat(fido).isEqualTo(fidosClone);

        // 재귀적 필드 비교 -> 성공
        // deprecated
        assertThat(fido).isEqualToComparingFieldByFieldRecursively(fidosClone);

        // 위를 대체할 수 있는 새로운 메서드
        // 더 많은 유연성과 더 나은 REPORT, 더 쉬운 사용법
        assertThat(fido).usingRecursiveComparison().isEqualTo(fidosClone);
    }

    @Test
    void BooleanAssertionTest() {
        assertThat("".isEmpty()).isTrue();
        assertThat("*".isEmpty()).isFalse();
    }

    @Test
    void IterableArrayAssertionTest() {
        List<String> list = Arrays.asList("1", "2", "3");
        assertThat(list).contains("1");
        assertThat(list).isNotEmpty();
        assertThat(list).startsWith("1");
        assertThat(list)
                .isNotEmpty()
                .contains("1")
                .doesNotContainNull()
                .containsSequence("2", "3");
    }

    @Test
    @DisplayName(" example of an assertion that checks if a provided character is not ‘a’, is in Unicode table, is greater than ‘b’ and is lowercase")
    void CharacterAssertionTest() {
        assertThat('x')
                .isNotEqualTo('a')
                .inUnicode()
                .isGreaterThanOrEqualTo('b')
                .isLowerCase();
    }

    @Test
    void ClassAssertionTest() {
        //인터페이스인가?
        assertThat(Runnable.class).isInterface();
        // 한 클래스가 다른 클래스에서 할당 가능한지 확인하려는 경우:
        assertThat(Exception.class).isAssignableFrom(NoSuchElementException.class);
    }

    @Test
    void FileAssertionTest() {
        File file = new File(".gitignore");
        assertThat(file)
                .exists()
                .isFile()
                .canRead()
                .canWrite();
    }

    @Test
    void DoubleFloatIntegerAssertionTest() {
        // 주어진 정밀도에 따라 두 값이 같은지 비교.
        assertThat(5.1).isEqualTo(5, withPrecision(1d));
        // detail : AbstractDoubleAssert  참조
    }

    @Test
    void InputStreamAssertionTest() {
        // 주어진 정밀도에 따라 두 값이 같은지 비교.
        assertThat(5.1).isEqualTo(5, withPrecision(1d));
        // detail : AbstractDoubleAssert  참조
    }

    @Test
    void BDDStyleAssertionTest() {
        // GIVEN
        String[] names = { "Pier ", "Pol", "Jak" };
        // WHEN
        Throwable thrown = catchThrowable(() -> System.out.println(names[9]));
        // THEN
        then(thrown).isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessageContaining("9");

        // assertThat 도 가능하지만 덜 "BDD style"하다.
        assertThat(thrown).isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessageContaining("9");
    }
}
