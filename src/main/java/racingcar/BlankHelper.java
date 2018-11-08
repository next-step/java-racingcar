package racingcar;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;

public class BlankHelper implements Helper<Integer> {

    public static final String NAME = "blanks";

    @Override
    public Object apply(Integer context, Options options) throws IOException {
        if(context == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<context; i++) {
            sb.append(options.fn(i + i));
        }

        return sb.toString();
    }
}
