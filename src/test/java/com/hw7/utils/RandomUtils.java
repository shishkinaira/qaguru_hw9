package com.hw7.utils;
import com.github.javafaker.Faker;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static Faker faker = new Faker();

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomPhone() {
        return String.format("%s%s", getRandomInt(11111, 99999), getRandomInt(11111, 99999));
    }

    public static String getRandomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public static String getRandomDay() {
        return String.format("%s", getRandomInt(1, 30));
    }

    public static String getRandomMonth() {
        return faker.options().option("January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October", "November", "December");
    }

    public static String getRandomYear() {
        return String.format("%s", getRandomInt(1900, 2050));
    }

    public static String getRandomHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public static String getRandomSubjects(){
        return faker.options().option("Hindi", "History", "Computer Science", "Commerce", "Maths",
                "Accounting", "English", "Physics", "Chemistry", "Civics", "Social Studies", "Biology");
    }

    public static String getRandomState(){
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String getRandomCity(String randomCity) {
        if (randomCity.equals("NCR")) {
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if (randomCity.equals("Uttar Pradesh")) {
            return faker.options().option("Agra", "Lucknow", "Merrut");
        } else if (randomCity.equals("Haryana")) {
            return faker.options().option("Karnal", "Panipat");
        } else if (randomCity.equals("Rajasthan")) {
            return faker.options().option("Jaipur", "Jaiselmer");
        }
            return null;
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
//
//    private static String getRandomItemFromArray(String[] values) {
//        int index = getRandomInt(0, values.length - 1);
//        return values[index];
//    }
//      public static String getRandomEmail() {
//    return getRandomString(5) + "@test.test";
//}
////    public static String getRandomCurrentAddress() {
//        return getRandomString(7);
//    }

//public static String getRandomString(int len) {
////        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//    String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//    SecureRandom rnd = new SecureRandom();
//
//    StringBuilder sb = new StringBuilder();
//    for (int i = 0; i < len; i++)
//        sb.append(AB.charAt(rnd.nextInt(AB.length())));
//    return sb.toString();
//}