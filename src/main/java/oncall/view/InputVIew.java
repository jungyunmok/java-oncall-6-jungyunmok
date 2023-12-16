package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputVIew {
    // 배정할 월과 시작 요일 받기
    public String readMonthDay() {
        System.out.println("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        String input = Console.readLine();
        return input;
    }

}
