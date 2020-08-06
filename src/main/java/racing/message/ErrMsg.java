package racing.message;

public enum ErrMsg {
    NAME_FORMAT_ERR("이름은 5글자 이하로만 가능합니다.");

    String msg;

    ErrMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
