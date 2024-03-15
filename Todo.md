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

## Done
- 화면에 자동차 대수 문구 출력(출력 => "자동차 대수는 몇 대 인가요?")
- 자동차 대수 입력(입력 => 3)
- 자동차 대수가 양의 정수가 아니라면 예외 발생(-1 => RuntimeException, "+" => RuntimeException)
- 화면에 횟수 문구 출력(출력 => "시도할 회수는 몇 회 인가요?")
- 횟수 입력(입력 => 5)
- 횟수가 양의 정수가 아니라면 예외 발생(-1 => RuntimeException, "+" => RuntimeException)
- 실행 결과 문구 출력(출력 => "실행 결과")
- 자동차 대수 별로 0 ~ 9 사이의 랜덤값 생성
- 생성된 랜덤값이 4 이상이라면 자동차 움직임를 더해줌(랜덤값 : 1 => 자동차 움직임, 4 => 자동차 움직임+1)
- 각 자동차의 움직임 출력(1 => "-", 3 => "---")
- 위의 4단계를 횟수만큼 반복

# Step4

## Todo

## Done
- Step3 개선 사항 : mvc(model, view, controller) 구조로 변경 (view <- controller -> model)
- Step3 개선 사항 : domain 내부에 view에 의존하는 로직 분리 (Car, Game)
- Step3 개선 사항 : GameInput에서도 view에 의존하는 로직 분리
- Step3 개선 사항 : Constant interface 제거 및 상수값들을 사용하는 클래스에서 직접 명시하도록 변경
- Step3 개선 사항 : NumberUtil 제거 이후에 GameClient 혹은 Game에 validation 옮기기
- Step3 개선 사항 : Game의 play도 테스트 코드 추가
- 문자열 출력("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
- 문자열 입력("pobi,crong,honux")
- 자동차 이름은 ","를 기준으로 구분("one,two,three" => one,two, "onetwo,three" => onetwo,three)
- 자동차 이름은 5글자를 초과할 수 없음("hihih" => "hihih", "hihihi" => RuntimeException)
- 거리 출력 시에 앞에 이름도 같이 출력("pobi : ---")
- 가장 많이 이동한 자동차들이 우승자로 선정("one -> 3, two -> 5" => two)
- 우승자는 한 명 이상일 수 있다("one -> 3, two -> 3" => one,two)
- 우승자 출력("pobi, honux가 최종 우승했습니다.")

# Step5

## Todo
- Step4 개선 사항 : GameClient에서 결과 조회나 자동차 생성과 같은 책임을 일급 컬렉션인 Game 내부로 옮긴다
- Step4 개선 사항 : Car를 출력하는 형식도 최대한 Car 내부에서 이뤄지도록 수정
 

## Done
- Step4 개선 사항 : NumberGenerator 구현체를 줄이는 방향으로 GameTest 개선하기
- Car 내부의 name, distance과 같은 원시값을 포장하는 책임을 분리 
- Step4 개선 사항 : 승자의 책임을 가지는 Winner 분리
