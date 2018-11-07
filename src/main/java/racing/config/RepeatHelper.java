package racing.config;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;

public class RepeatHelper implements Helper<Integer> {

    @Override
    public Object apply(final Integer context, final Options options) throws IOException {

        if (context == null) {
            return "";
        }

        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < context; i++) {
            sb.append(options.fn(i + 1));
        }

        return sb.toString();
    }
}
