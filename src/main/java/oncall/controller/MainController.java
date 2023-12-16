package oncall.controller;

import oncall.model.Exception;
import oncall.model.MonthMaker;
import oncall.model.Schedule;
import oncall.model.Worker;
import oncall.view.InputVIew;
import oncall.view.OutputVIew;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainController {
    InputVIew inputVIew = new InputVIew();
    OutputVIew outputVIew = new OutputVIew();
    Exception exception = new Exception();
    MonthMaker monthMaker = new MonthMaker();
    Worker worker = new Worker();
    Schedule schedule = new Schedule();

    // 비상근무표 자동화 시작
    public void start() {
        List<String> monthInfo = fixMonth();
        Map<String, List<String>> workerList = fixWorkerList();
        fixSchedule(monthInfo, workerList);
    }

    // 월과 요일 입력하고 달력 반환하기
    private List<String> fixMonth() {
        List<String> monthInfo = null;
        try {
            String monthDay = inputVIew.readMonthDay();
            Map<Integer, String> startInfo = exception.checkMonthDay(monthDay);
            monthInfo = monthMaker.returnMonth(startInfo);
            monthInfo = monthMaker.addHoliday(monthInfo);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            fixMonth();
        }
        return monthInfo;
    }

    // 비상 근무 사원 입력
    private Map<String, List<String>> fixWorkerList() {
        List<String> weekdayList = null;
        List<String> weekendList = null;
        try {
            weekdayList = validateList("평일");
            weekendList = validateList("휴일");
            worker.checkSameWorker(weekdayList, weekendList);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            fixWorkerList();
        }
        Map<String, List<String>> workerList = new HashMap<>();
        workerList.put("평일", weekdayList);
        workerList.put("휴일", weekendList);
        return workerList;
    }

    // 유효한 사원인지 검사
    private List<String> validateList(String whichDay) {
        List<String> tempList = null;
        if (whichDay.equals("평일")) {
            String weekday = inputVIew.readWeekday();
            tempList = worker.checkWorker(weekday);
            worker.validateWorker(tempList);
            return tempList;
        }
        String weekend = inputVIew.readWeekend();
        tempList = worker.checkWorker(weekend);
        worker.validateWorker(tempList);
        return tempList;
    }

    // 근무 스케줄 짜고 출력하기
    private void fixSchedule(List<String> monthInfo, Map<String, List<String>> workerList) {
        List<String> weekdayWorker = workerList.get("평일");
        List<String> weekendWorker = workerList.get("휴일");
        monthInfo = schedule.makeSchedule(monthInfo, weekdayWorker, weekendWorker);
        String lastWord = monthInfo.get(monthInfo.size()-1);
        do {
            monthInfo = schedule.makeSchedule(monthInfo, weekdayWorker, weekendWorker);
        } while ((monthInfo.get(monthInfo.size()-1)).equals(lastWord));
        outputVIew.printSchedule(monthInfo);
    }
}
