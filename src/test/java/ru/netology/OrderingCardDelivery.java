package ru.netology;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class OrderingCardDelivery {

    LocalDate today = LocalDate.now();
    LocalDate newDate = today.plusDays(3);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Test
    void shouldRequestForCard() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Пенза");
        $("[data-test-id=date] input").doubleClick().sendKeys(formatter.format(newDate));
        $("[data-test-id=name] input").setValue("Иванов Иван");
        $("[data-test-id=phone] input").setValue("+79200252879");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(withText("Успешно!")).waitUntil(exist, 15000);
    }
}
