# 문자열 덧셈 계산기를 통한 TDD 실습

## 기능 요구사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## 프로그래밍 요구사항

- 메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.

## 기능 목록
* [X] 빈 문자열 또는 null 값인 경우 0을 반환
* [X] 숫자가 하나일 때 숫자 그대로의 값을 반환
* [X] 숫자 두개를 컴마 구분자로 입력 할 경우 두 숫자의 합을 반환
* [ ] 구분자를 컴마 외에 콜론을 사용
* [ ] \\와 \n 문자 사이에 커스텀 구분자를 지정
* [ ] 음수를 전달할 경우 RuntimeException 예외