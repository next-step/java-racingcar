# Step 2

link: https://edu.nextstep.camp/s/Ie5Dwep0/ls/oD18sXzO

문자열 덧셈 계산기

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이
  값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## ToDo

- [x] 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : "" => 0, null => 0)

```
if (text == null) {}
if (text.isEmpty()) {}
```

- [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : "1")

```
int number = Integer.parseInt(text);
```

- [x] 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : "1,2")

```
String[] numbers = text.split(",");
// 앞 단계의 구분자가 없는 경우도 split()을 활용해 구현할 수 있는지 검토해 본다.
```

- [ ] 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : "1,2:3" => 6)

```
String[] tokens= text.split(",|:");
```

- [ ] "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : "//;\n1;2;3" => 6)

```
// java.util.regex 패키지의 Matcher, Pattern import
Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
if (m.find()) {
String customDelimiter = m.group(1);
String[] tokens= m.group(2).split(customDelimiter);
// 덧셈 구현
}
```

- [ ] 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : "-1,2,3")

```
구글에서 “junit4 expected exception”으로 검색해 해결책을 찾는다.
```
