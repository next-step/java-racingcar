package racingcar.study.staticfactory.example;
//import lombok.RequiredArgsConstructor;

import javax.xml.namespace.QName;

//@RequiredArgsConstructor(staticName = "of")
public class BlogUser {
    private final Long id;
    private final String name;

    private BlogUser(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static final BlogUser of(Long id, String name) {
        return new BlogUser(id, name);
    }
}
