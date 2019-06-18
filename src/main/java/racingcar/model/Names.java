package racingcar.model;

import com.google.common.base.Strings;

import java.util.Arrays;
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
        validateEmpty(names);
        NamesValidator.validate(names);

        List<String> nameList = Arrays.stream(names.split(DELIMITER))
                .collect(toList());

        return new Names(nameList);
    }

    private static void validateEmpty(String name) {
        if (name == null || Strings.isNullOrEmpty(name.trim())) {
            throw new NameException("빈 문자열 입니다");
        }
    }

    public Stream<String> stream() {
        return names.stream();
    }

    public List<String> getNames() {
        return names;
    }
    public int size(){
        return names.size();
    }

    @Override
    public String toString() {
        return "Names{" + "names=" + names + '}';
    }
}
