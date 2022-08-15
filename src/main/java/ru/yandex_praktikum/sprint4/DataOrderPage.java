package ru.yandex_praktikum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// страница с перс данными
public class DataOrderPage {
    private WebDriver driver;
    // локатор поля Имя
    private By fieldName = By.xpath(".//input[@placeholder='* Имя']");
    //локатор поля Фамилия
    private By fieldSurName= By.xpath(".//input[@placeholder='* Фамилия']");
    //локатор пункт 1 выпадающего списока в разделе «Вопросы о важном»
    private By fieldAdress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор пункт 2 выпадающего списока в разделе «Вопросы о важном»
    private By fieldMetro = By.xpath(".//input[@placeholder='* Станция метро']");
    //локатор пункт 3 выпадающего списока в разделе «Вопросы о важном»
    private By fieldTelefon = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // кнопка Далее
    private By buttonNext = By.xpath("//button[text()='Далее']");

    public DataOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // установить значение в поле name
    public void setFieldName(String name) {
        driver.findElement(fieldName).clear();
        driver.findElement(fieldName).sendKeys(name);
    }

    public void setFieldSurName(String surName) {
        driver.findElement(fieldSurName).clear();
        driver.findElement(fieldSurName).sendKeys(surName);
    }

    public void setFieldAdress(String adress) {
        driver.findElement(fieldAdress).clear();
        driver.findElement(fieldAdress).sendKeys(adress);
    }

    public void setFieldMetro(String metro) {
        driver.findElement(fieldMetro).clear();
        driver.findElement(fieldMetro).sendKeys(metro + Keys.DOWN + Keys.ENTER);
    }

    public void setFieldTelefon(String telefon) {
        driver.findElement(fieldTelefon).clear();
        driver.findElement(fieldTelefon).sendKeys(telefon);
    }

    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    // метод ожидания загрузки страницы с данными о заказе
    public void waitForLoadOrderPage() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(buttonNext));
    }
}


