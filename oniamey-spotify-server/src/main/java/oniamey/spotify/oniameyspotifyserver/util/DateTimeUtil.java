package oniamey.spotify.oniameyspotifyserver.util;


import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {

    public static Long convertDateToTimeStampSecond(Date startDate) {
        if (startDate != null) {
            return startDate.getTime() / 1000;
        }
        return null;
    }

    public static Date addMinutes(Date date, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }

    public static Long getCurrentTimeStampSecond() {
        return System.currentTimeMillis() / 1000;
    }

}
