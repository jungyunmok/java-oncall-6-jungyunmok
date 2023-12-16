package oncall.constant;

import java.util.List;

public enum Days {
    D1(0, "월"),
    D2(1, "화"),
    D3(2, "수"),
    D4(3, "목"),
    D5(4, "금"),
    D6(5, "토"),
    D7(6, "일");

    private final int DAYS_INDEX;
    private final String DAYS_NAME;

    Days(int DAYS_INDEX, String DAYS_NAME) {
        this.DAYS_INDEX = DAYS_INDEX;
        this.DAYS_NAME = DAYS_NAME;
    }

    public int getDAYS_INDEX() {
        return DAYS_INDEX;
    }

    public String getDAYS_NAME() {
        return DAYS_NAME;
    }
}
