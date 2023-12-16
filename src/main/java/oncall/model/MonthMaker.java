package oncall.model;

import oncall.constant.Days;
import oncall.constant.Holiday;
import oncall.constant.Month;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MonthMaker {
    private List<String> monthInfo = new ArrayList<>();

    public List<String> getMonthInfo() {
        return monthInfo;
    }

    // 받은 월과 시작요일로 달력 만들기
    public List<String> returnMonth(Map<Integer, String> startInfo) {
        int startMonth = 0;
        String startDay = "";
        for (Integer key : startInfo.keySet()) {
            startMonth = key;
            startDay = startInfo.get(key);
        }
        int dayCount = returnDayCount(startMonth);
        List<String> monthInfo = makeMonth(startMonth, dayCount, startDay);
        return monthInfo;
    }

    // 해당 월에 맞는 일수 반환
    private int returnDayCount(int startMonth) {
        int dayCount = 0;
        for (Month month : Month.values()) {
            if (month.getMONTHLIST().contains(startMonth)) {
                dayCount = month.getDAYS_COUNT();
                return dayCount;
            }
        }
        return dayCount;
    }

    // 달력 만들어 반환하기
    private List<String> makeMonth(int startMonth, int dayCount, String startDay) {
        int index = findIndex(startDay);
        List<String> monthInfo = repeatInsert(startMonth, dayCount, index);
        return monthInfo;
    }

    // 맞는 시작 요일 인덱스 찾기
    private int findIndex(String startDay) {
        int index = 0;
        for (Days days : Days.values()) {
            if (startDay.equals(days.getDAYS_NAME())) {
                index = days.getDAYS_INDEX();
                return index;
            }
        }
        return index;
    }

    // 인덱스로 반복해서 날짜 넣기
    private List<String> repeatInsert(int startMonth, int dayCount, int index) {
        List<String> monthInfo = new ArrayList<>();
        int date = 1;
        while (date <= dayCount) {
            date = addInfo(date, dayCount, monthInfo, index, startMonth);
            index++;
            if (index > 6) {
                index = 0;
            }
        }
        return monthInfo;
    }

    // 조건 판단하고 정보 넣어서 리턴하기
    private int addInfo(int date, int dayCount, List<String> monthInfo, int index, int startMonth) {
        for (Days days : Days.values()) {
            if (index == days.getDAYS_INDEX() && date <= dayCount) {
                monthInfo.add(startMonth + "월 " + date + "일 " + days.getDAYS_NAME());
                date++;
            }
        }

        return date;
    }

    // 법정 공휴일일 경우 뒤에 (휴일) 붙여주기
    public List<String> addHoliday(List<String> monthInfo) {
        for (int i = 0; i < monthInfo.size(); i++) {
            if (checkHoliday(monthInfo.get(i))) {
                monthInfo.set(i, monthInfo.get(i) + "(휴일)");
            }
        }
        this.monthInfo = monthInfo;
        return monthInfo;
    }

    // 휴일인지 확인
    private boolean checkHoliday(String monthData) {
        for (Holiday holiday : Holiday.values()) {
            if (holiday.getHOLIDAYLIST().contains(monthData.substring(0,monthData.length()-2))) {
                return true;
            }
        }
        return false;
    }
}
