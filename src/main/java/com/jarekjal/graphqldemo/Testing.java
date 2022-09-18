package com.jarekjal.graphqldemo;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Testing {
    public static void main(String[] args) {

        //https://stackoverflow.com/questions/5677470/java-why-is-the-date-constructor-deprecated-and-what-do-i-use-instead
        ZoneId zoneId_Norway = ZoneId.of( "Europe/Oslo" );
        ZonedDateTime zdt_Norway = ZonedDateTime.of( 1985 , 1 , 1 , 3 , 2 , 1 , 0 , zoneId_Norway );

        ZoneId zoneId_NewYork = ZoneId.of( "America/New_York" );
        ZonedDateTime zdt_NewYork = zdt_Norway.withZoneSameInstant( zoneId_NewYork );

        ZonedDateTime zdt_Utc = zdt_Norway.withZoneSameInstant( ZoneOffset.UTC );  // Or, next line is similar.
        Instant instant = zdt_Norway.toInstant();  // Instant is always in UTC.

        LocalDate localDate_Norway = zdt_Norway.toLocalDate();

        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("sytemowa strefa: " + ZoneOffset.systemDefault());
        System.out.println(now);
        ZonedDateTime nowUTC = now.withZoneSameInstant(ZoneOffset.UTC);
        System.out.println(nowUTC);
        System.out.println(nowUTC.truncatedTo(ChronoUnit.SECONDS));
        System.out.println(nowUTC.toLocalDate());

    }
}
