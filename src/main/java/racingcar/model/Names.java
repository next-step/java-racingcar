package racingcar.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Names{

    public static final String DELIMITER = "\\,";
    private List<String> names;

    Names(List<String> names) {
        this.names = names;
    }

    public static Names from(String names){
        NamesValidator.validate(names);

        List<String> nameList = Arrays.stream(names.split(DELIMITER))
                .collect(toList());

        return new Names(nameList);
    }

    public Stream<String> stream() {
        return names.stream();
    }

    public List<String> getList() {
        return Collections.unmodifiableList(names);
    }

    @Override
    public String toString() {
        return "Names{" + "names=" + names + '}';
    }
}
