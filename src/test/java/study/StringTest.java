package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author : dokim
 * @version :
 * @see <pre>
 * == Modification Information ==<br/>
 *
 *         Date        :       User          :     Description      <br/>
 * ---------------------------------------------------------------  <br/>
 *       2019-10-24      :       dokim        :                       <br/>
 *
 * </pre>
 * @since : 2019-10-24
 **/
public class StringTest {
    @Test
    void charAt() {
        assertThatThrownBy(() -> {
            "123".charAt(3);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("3");
    }

    @Test
    void subString() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

}