package carracing.domain;

public class Name {
    private final String Name;

    private static final int MAX_NAME_LENGTH =5;

    public Name(final String name){
        checkLength(name);
        checkNullAndEmpth(name);
        this.Name=name;
    }

    private void checkLength(String name){
        if(name.length()>MAX_NAME_LENGTH){
            throw new IllegalArgumentException("이름은 5자를 넘을 수 없습니다.");
        }
    }

    private void checkNullAndEmpth(String name){
        if(name.isEmpty()||name.equals("")||name==null){
            throw new IllegalArgumentException("이름이 Null 혹은 빈문자열 입니다.");
        }
    }

    @Override
    public String toString() {
        return Name;
    }
}
