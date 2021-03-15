package step4.domain.startegy.name;

// 길이가 아니라, 포함된 단어? 같은 것들도 해당 전략패턴으로 구현할 수 있도록, NamingStrategy 라 명명했습니다.
public interface NamingStrategy {

    boolean isValidate(String name);

}
