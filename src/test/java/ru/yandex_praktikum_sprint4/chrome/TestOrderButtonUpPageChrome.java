package ru.yandex_praktikum_sprint4.chrome;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import ru.yandex_praktikum.sprint4.DataOrderPage;
import ru.yandex_praktikum.sprint4.DataRentPage;
import ru.yandex_praktikum.sprint4.HomePage;

@RunWith(Parameterized.class)
public class TestOrderButtonUpPageChrome {
    private final String name;
    private final String surName;
    private final String adress;
    private final String metro;
    private final String telefon;
    private final String data;
    private final int period;
    private final int color;
    private final String coment;
    WebDriver driver;

    public TestOrderButtonUpPageChrome(String name, String surName, String adress, String metro, String telefon, String data, int period, int color, String coment) {
        this.name = name;
        this.surName = surName;
        this.adress = adress;
        this.metro = metro;
        this.telefon = telefon;
        this.data = data;
        this.period = period;
        this.color = color;
        this.coment = coment;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getData() {
        return new Object[][] {
                { "Иван","Иванов","Москва","Комсомольская","+7911111111","30.07.2022",0,0,"Проверка"},
                { "Петр","Петров","Питер","Сокольники","+7922222222","31.07.2022",1,1,""},
        };
    }

    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver","C:/WebDriver/chromedriver.exe");
        driver = new ChromeDriver();
        // подключаемся к странице
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        DataOrderPage  objOrderPage = new DataOrderPage(driver);
        DataRentPage   objRentPage = new DataRentPage(driver);
        // подтвержадем сбор куки
        objHomePage.clickCookieButton();
        // ждем кликабельности кнопки
        objHomePage.waitForLoadOrderButtonUpPage();
        objHomePage.clickOrderButtonUpPage();
        //Ждем загрузки и заполняем поля
        objOrderPage.waitForLoadOrderPage();
        objOrderPage.setFieldName(name);
        objOrderPage.setFieldSurName(surName);
        objOrderPage.setFieldAdress(adress);
        objOrderPage.setFieldMetro(metro+ Keys.DOWN+ Keys.ENTER);
        objOrderPage.setFieldTelefon(telefon);
        objOrderPage.clickButtonNext();
        // заполняем поля с арендой
        objRentPage.waitForLoadOrderPage();
        objRentPage.setFieldData(data+ Keys.ENTER);
        objRentPage.setFieldPeriod(period);
        objRentPage.setFieldColor(color);
        objRentPage.setFieldComent(coment);
        objRentPage.clickOrderButton();
        //ждем загрузки модального окна подтверждения заказа
        objRentPage.waitForLoadOrderModalHeader();
        // кликаем ок
        objRentPage.clickOkButton();
         // ищем финальное окно
        objRentPage.setOrderModalFinal();
    }
    @After
    public void test1down() {
        // Закрываем браузер
        driver.quit();
    }
}
