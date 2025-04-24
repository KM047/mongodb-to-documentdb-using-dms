package com.kunal.migration_mongodb_documentdb.serviceTest;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Demo {

    public static void main(String[] args) {

        ZonedDateTime fixedTime = ZonedDateTime.of(2025, 4, 22, 10, 45, 0, 0, ZoneOffset.UTC);
        String formatted = fixedTime.format(DateTimeFormatter.ISO_INSTANT);
        System.out.println(LocalDateTime.now());

    }
}
