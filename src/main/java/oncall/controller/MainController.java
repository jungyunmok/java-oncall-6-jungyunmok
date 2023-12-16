package oncall.controller;

import oncall.model.Exception;
import oncall.model.MonthMaker;
import oncall.view.InputVIew;
import oncall.view.OutputVIew;

import java.util.List;
import java.util.Map;

public class MainController {
    InputVIew inputVIew = new InputVIew();
    OutputVIew outputVIew = new OutputVIew();
    Exception exception = new Exception();
    MonthMaker monthMaker = new MonthMaker();


    // 시작
    public void start() {

    }

    // 월과 요일 입력하고 달력 반환하기
    private List<String> fixMonth() {
        List<String> monthInfo = null;
        try {
            String monthDay = inputVIew.readMonthDay();
            Map<Integer, String> startInfo = exception.checkMonthDay(monthDay);
            monthInfo = monthMaker.returnMonth(startInfo);
            monthInfo = monthMaker.addHoliday(monthInfo);
             return monthInfo;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            fixMonth();
        }
        return monthInfo;
    }

}
