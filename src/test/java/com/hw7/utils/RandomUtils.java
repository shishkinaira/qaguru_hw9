package com.hw7.utils;
import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {


    public static String getRandomString(int len) {
//        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String getRandomEmail() {
        return getRandomString(5) + "@test.test";
    }


    public static String getRandomCurrentAddress() {
        return getRandomString(7);
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomPhone() {
        return String.format("%s%s", getRandomInt(11111, 99999), getRandomInt(11111, 99999));
    }


    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }

    private static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);
        return values[index];
    }


}

// +3 (263) 253 - 66 - 12  оставлю в закромах
//    public static String getRandomPhone() {
//        return String.format("+%s (%s) %s - %s - %s", getRandomInt(1, 9), getRandomInt(111, 999),
//                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 90));
//    }

//    public static String getRandomUuid() {
//        return UUID.randomUUID().toString();
//    }