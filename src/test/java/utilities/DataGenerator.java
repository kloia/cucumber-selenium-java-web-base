package utilities;


import com.github.javafaker.Faker;

import java.util.Random;

public class DataGenerator {
    public static Faker faker = new Faker();

    public static String generateRandomString(int range) {
        String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder randStr = new StringBuilder();
        for (int i = 0; i < range; i++) {
            int number = new Random().nextInt(CHAR_LIST.length());
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    public static String generateRandomInteger(int range) {
        String CHAR_LIST = "1234567890";
        StringBuilder randStr = new StringBuilder();
        for (int i = 0; i < range; i++) {
            int number = new Random().nextInt(CHAR_LIST.length());
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    public static String generateRandomEmail() {
        return faker.name().username() + "@test.com";
    }

    public static String generateRandomName() {
        return faker.name().firstName().replaceAll("[^A-Za-z]", "").toUpperCase();
    }

    public static String generateRandomSurname() {
        return faker.name().lastName().replaceAll("[^A-Za-z]", "").toUpperCase();
    }

    public static String generateRandomAddress() {
        Faker faker = new Faker();

        String streetAddress = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String country = faker.address().country();
        String zipCode = faker.address().zipCode();

        return streetAddress + ", " + city + ", " + state + ", " + country + ", " + zipCode;
    }

    public static String generateRandomStreetAddress() {
        return faker.address().streetAddress();
    }

    public static String generateRandomCity() {
        return faker.address().city();
    }

    public static String generateRandomState() {
        return faker.address().state();
    }

    public static String generateRandomCountry() {
        return faker.address().country();
    }

    public static String generateRandomZipCode() {
        return faker.address().zipCode();
    }

    public static String createPassword() {
        return faker.internet().password();
    }

    public static String generateRandomPhoneNumber() {
        Faker faker = new Faker();
        StringBuilder phoneNumber = new StringBuilder("507");

        for (int i = 0; i < 7; i++) {
            int digit = faker.random().nextInt(10);
            phoneNumber.append(digit);
        }

        return phoneNumber.toString();
    }

    public static String generateRandomBirthday() {
        int day = faker.number().numberBetween(1, 31);
        return String.format("%02d", day);
    }

    public static String generateRandomBirthMonth() {
        int month = faker.number().numberBetween(1, 12);
        return switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> throw new IllegalStateException("Unexpected value: " + month);
        };
    }

    public static String generateRandomBirthYear() {
        int year = faker.number().numberBetween(1900, 2023);
        return String.valueOf(year);
    }
}
