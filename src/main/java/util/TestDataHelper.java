package util;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestDataHelper {

    private final static Faker FAKER = Faker.instance();

    public static String getFutureDate(int plusDays, DateTimeFormatter dateFormat){
        return LocalDate.now().plusDays(FAKER.number().randomNumber(plusDays, true)).format(dateFormat);
    }

    public static Faker getFaker(){
        return FAKER;
    }
}