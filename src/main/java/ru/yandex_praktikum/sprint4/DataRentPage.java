package ru.yandex_praktikum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataRentPage {
    private WebDriver driver;
    // локаторы полей формы об аренде
    // локатор поля дата заказа
    private final By fieldData = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // локатор поля срок аренды
    private final By fieldPeriod = By.className("Dropdown-placeholder");
    private final By fieldPeriodDay = By.xpath(".//div[@class='Dropdown-option' and contains(text(),'сутки')]");
    // локатор поля цвет самоката
    private final By fieldColorBlack = By.id("black");
    private final By fieldColorGrey = By.id("grey");
    // локатор поля коментарий
    private final By fieldComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // локатор кнопки Заказать
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM'  and contains(text(),'Заказать')]");
    private final By okButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM'  and contains(text(),'Да')]");
    // Константы цветов самоката
    private final String GREY = "Grey";
    private final String BLACK = "Black";

    // методы зполнения полей формы Аренды
    public DataRentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFieldData(String date) {
        driver.findElement(fieldData).clear();
        driver.findElement(fieldData).sendKeys(date + Keys.ENTER);
    }

    public void setFieldPeriodDay() {
        driver.findElement(fieldPeriod).click();
        driver.findElement(fieldPeriodDay).click();
    }

    public void setСolor(String scooterColor) {
        if (scooterColor.equals(GREY)) {
            driver.findElement(fieldColorGrey).click();
        } else if (scooterColor.equals(BLACK)) {
            driver.findElement(fieldColorBlack).click();
        }
    }

    public void setFieldComent(String coment) {
        driver.findElement(fieldComment).sendKeys(coment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void waitForLoadOrderPage() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
    }

    public void clickOkButton() {
        driver.findElement(okButton).click();
    }
}
