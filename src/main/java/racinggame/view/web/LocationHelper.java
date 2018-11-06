package racinggame.view.web;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;

public class LocationHelper implements Helper<Integer> {
    @Override
    public Object apply(Integer context, Options options) throws IOException {
        if(context == null){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < context; i++) {
            sb.append(options.fn(i + 1));
        }
        return sb.toString();
    }
}
