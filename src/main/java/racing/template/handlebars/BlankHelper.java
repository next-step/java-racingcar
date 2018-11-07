package racing.template.handlebars;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;

/**
 * 공백 만들어주는 헬퍼
 */
public class BlankHelper implements Helper<Integer> {
    @Override
    public Object apply(Integer context, Options options) throws IOException {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < context; i++) {
            sb.append("&nbsp");
        }
        return sb.toString();
    }
}
