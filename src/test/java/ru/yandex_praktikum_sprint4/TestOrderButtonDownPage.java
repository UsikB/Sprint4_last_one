package ru.yandex_praktikum_sprint4;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex_praktikum.sprint4.DataOrderPage;
import ru.yandex_praktikum.sprint4.DataRentPage;
import ru.yandex_praktikum.sprint4.HomePage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestOrderButtonDownPage {
    WebDriver driver;
    private String name;
    private String surName;
    private String adress;
    private String metro;
    private String telefon;
    private String data;
    private String color;
    private String coment;

    public TestOrderButtonDownPage(String choosedDriver, String name, String surName, String adress, String metro, String telefon, String data, String color, String coment)
    {
        this.name = name;
        this.surName = surName;
        this.adress = adress;
        this.metro = metro;
        this.telefon = telefon;
        this.data = data;
        this.color = color;
        this.coment = coment;
        if(choosedDriver.equals("Chrome")){
            driver = new ChromeDriver();
        }else if(choosedDriver.equals("FireFox")){
            driver = new FirefoxDriver();
        }

    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                { "Chrome","Иван","Иванов","Москва","Комсомольская","+7911111111","30.07.2022","Grey","Проверка"},
                { "Chrome","Петр","Петров","Питер","Сокольники","+7922222222","31.07.2022","Black",""},
                { "FireFox","Иван","Иванов","Москва","Комсомольская","+7911111111","30.07.2022","Grey","Проверка"},
                { "FireFox","Петр","Петров","Питер","Сокольники","+7922222222","31.07.2022","Black",""},
        };
    }

    @Test
    public void TestOrderButtonDownPageSuccessOrder() {
        // подключаемся к странице
        HomePage objHomePage = new HomePage(driver);
        DataOrderPage  objOrderPage = new DataOrderPage(driver);
        DataRentPage   objRentPage = new DataRentPage(driver);
        driver.get(objHomePage.getMainPageLink());
        // подтвержадем сбор куки
        objHomePage.clickCookieButton();
        // ждем кликабельности кнопки
        objHomePage.scrollToButtonDownPage();
        objHomePage.waitForLoadOrderButtonDownPage();
        objHomePage.clickOrderButtonDownPage();
        //Ждем загрузки и заполняем поля
        objOrderPage.waitForLoadOrderPage();
        objOrderPage.setFieldName(name);
        objOrderPage.setFieldSurName(surName);
        objOrderPage.setFieldAdress(adress);
        objOrderPage.setFieldMetro(metro);
        objOrderPage.setFieldTelefon(telefon);
        objOrderPage.clickButtonNext();
        // заполняем поля с арендой
        objRentPage.waitForLoadOrderPage();
        objRentPage.setFieldData(data);
        objRentPage.setFieldPeriodDay();
        objRentPage.setСolor(color);
        objRentPage.setFieldComent(coment);
        objRentPage.clickOrderButton();
        objRentPage.clickOkButton();
        String actualElement = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[5]/div[1]"))).getText();
        assertEquals("Текст должен совпадать",true, actualElement.startsWith("Заказ оформлен"));
    }
    @After
    public void tearDown() {
        // Закрываем браузер
        driver.quit();
    }
}
