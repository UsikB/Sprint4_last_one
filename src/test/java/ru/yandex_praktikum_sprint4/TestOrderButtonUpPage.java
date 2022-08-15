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
public class TestOrderButtonUpPage{
    private String name;
    private String surName;
    private String adress;
    private String metro;
    private String telefon;
    private String data;
    private String color;
    private String coment;
    WebDriver driver;

    // Конструктор класса с тестируемыми полями в качестве параметров, чтобы запускать тесты с помощью параметризации
    public TestOrderButtonUpPage(String choosedDriver, String name, String surName, String adress, String metro, String telefon, String data, String color, String coment)
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

    // набор кейсов для проверки позитивного сценария заказа
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
    public void TestOrderButtonUpPageSuccessOrder() {
        HomePage objHomePage = new HomePage(driver);
        DataOrderPage  objOrderPage = new DataOrderPage(driver);
        DataRentPage   objRentPage = new DataRentPage(driver);
        // подключаемся к странице
        driver.get(objHomePage.getMainPageLink());
        // подтвержадем сбор куки
        objHomePage.clickCookieButton();
        // ждем кликабельности кнопки "Заказать" в верхней части страницы
        objHomePage.waitForLoadOrderButtonUpPage();
        // кликаем на кнопку "Заказать" в верхней части страницы
        objHomePage.clickOrderButtonUpPage();
        //Ждем загрузки страницы
        objOrderPage.waitForLoadOrderPage();
        // Заполняем поле "Имя"
        objOrderPage.setFieldName(name);
        // Заполняем поле "Фамилия"
        objOrderPage.setFieldSurName(surName);
        // Заполняем поле "Адрес"
        objOrderPage.setFieldAdress(adress);
        // Заполняем поле "Метро"
        objOrderPage.setFieldMetro(metro);
        // Заполняем поле "Телефон"
        objOrderPage.setFieldTelefon(telefon);
        // Нажимаем кнопку "Далее"
        objOrderPage.clickButtonNext();
        // ждем загрузку следующей страницы
        objRentPage.waitForLoadOrderPage();
        // Заполняем поле "Дата"
        objRentPage.setFieldData(data);
        // Заполняем поле "Срок аренды"
        objRentPage.setFieldPeriodDay();
        // Заполняем поле "Цвет самоката"
        objRentPage.setСolor(color);
        // Заполняем поле "Комментарий для курьера"
        objRentPage.setFieldComent(coment);
        // Нажимаем кнопку "Заказать"
        objRentPage.clickOrderButton();
        // Подтверждаем заказ
        objRentPage.clickOkButton();
        // Сравниваем всплывшее модальное окно об "Успешном заказе" с тем, что должно быть.
        String actualElement = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[5]/div[1]"))).getText();
        assertEquals("Текст должен совпадать",true, actualElement.startsWith("Заказ оформлен"));
    }
    @After
    public void tearDown() {
        // Закрываем браузер
        driver.quit();
    }
}
