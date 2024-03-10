## Todo

## Done
- null을 전달할 경우에는 0을 반환(null => 0)
- 빈 문자열이 전달될 경우에는 0을 반환(“” => 0)
- 숫자 하나를 입력하면 해당 숫자를 반환("1" => "1")
- 쉼표(,)를 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환("1,2" => 3)
- 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환("1:2" => 3)
- "//"와 "\n" 사이의 문자열이 존재할 경우 해당 문자를 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환("//;\n1;2;3" => 6)
- 문자열 계산기에 숫자 이외의 값을 전달하는 경우 RuntimeException 예외를 throw("1,+" => exception)
- 문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외를 throw("-1,2" => exception)

# Step3

## Todo
- 자동차 대수 별로 0 ~ 9 사이의 랜덤값 생성
- 생성된 랜덤값이 4 이상이라면 자동차 움직임를 더해줌(랜덤값 : 1 => 자동차 움직임, 4 => 자동차 움직임+1)
- 각 자동차의 움직임 출력(1 => "-", 3 => "---")
- 위의 4단계를 횟수만큼 반복

## Done
- 화면에 자동차 대수 문구 출력(출력 => "자동차 대수는 몇 대 인가요?")
- 자동차 대수 입력(입력 => 3)
- 자동차 대수가 양의 정수가 아니라면 예외 발생(-1 => RuntimeException, "+" => RuntimeException)
- 화면에 횟수 문구 출력(출력 => "시도할 회수는 몇 회 인가요?")
- 횟수 입력(입력 => 5)
- 횟수가 양의 정수가 아니라면 예외 발생(-1 => RuntimeException, "+" => RuntimeException)
- 실행 결과 문구 출력(출력 => "실행 결과")