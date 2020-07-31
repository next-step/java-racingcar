package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String result[] = "1,2".split(",");

        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1","2");
        assertThat(result[0]).isEqualTo("1");
    }

    @Test
    void substring() {
        String input ="(1,2)";

        String result = input.substring(1,input.length()-1);

        assertThat(result).isEqualTo("1,2");
        assertThat(result).hasSize(3);
    }

    @Test
    @DisplayName("charAt()테스트")
    void charAt() {
        String input ="abc";

        assertThatThrownBy(()->{
            char c=  "abc".charAt(3);

        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                 .hasMessageContaining("out of range");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(()->{
                    char c = "temp".charAt(4);
                });

        assertThatThrownBy(()->{
                List<String> list = Arrays.asList("String one","String two");
                list.get(2);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                 .hasMessageContaining("2");

    }

    class Dog{
        private String name;
        private double weigth;

        public Dog(String name, double weigth) {
            this.name = name;
            this.weigth = weigth;
        }
    }

    @Test
    void testDog() {
        Dog fido = new Dog("Fido",5.25);
        Dog fidosClone = new Dog("Fido",5.25);
//        assertThat(fido).isEqualTo(fidosClone);
        assertThat(fido).isEqualToComparingFieldByFieldRecursively(fidosClone);
    }
}

