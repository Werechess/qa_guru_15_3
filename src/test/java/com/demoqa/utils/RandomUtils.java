package com.demoqa.utils;

import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class RandomUtils {

    public static String getRandomString(int length) {

        String ALLCHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        StringBuilder result = new StringBuilder();
        Random random = new Random();

        while (result.length() < length) {
            int index = (int) (random.nextFloat() * ALLCHARS.length());
            result.append(ALLCHARS.charAt(index));
        }

        return result.toString();
    }

    public static String getRandomEmail() {
        return getRandomString(9) + "@gmail.com";
    }

    public static String getRandomPhone() {
        return randomNumeric(10);
    }

    public enum Gender {
        Male,
        Female,
        Other;

        public static String getRandomGender() {
            int genderPick = new Random().nextInt(Gender.values().length);
            return String.valueOf(Gender.values()[genderPick]);
        }
    }

    public static String getRandomDay() {
        // Random get values between 0 (inclusive) and bound (exclusive), so need to subtract and add offset
        int day = new Random().nextInt(29 - 1) + 1;

        if (day <= 9) {
            return "0" + day;
        } else {
            return String.valueOf(day);
        }
    }

    public enum Month {
        January,
        February,
        March,
        April,
        May,
        June,
        July,
        August,
        September,
        October,
        November,
        December;

        public static String getRandomMonth() {
            int monthPick = new Random().nextInt(Month.values().length);
            return String.valueOf(Month.values()[monthPick]);
        }
    }
}
