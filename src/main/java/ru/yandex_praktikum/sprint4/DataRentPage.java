package ru.yandex_praktikum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DataRentPage {
    private WebDriver driver;
    // локаторы полей формы об аренде
    // локатор поля дата заказа
    private final By fieldData = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // локатор поля срок аренды
    private final By fieldPeriod= By.className("Dropdown-placeholder");
    private final By fieldPeriodSelected1= By.xpath(".//div[@class='Dropdown-option' and contains(text(),'сутки')]");
    private final By fieldPeriodSelected2= By.xpath(".//div[@class='Dropdown-option' and contains(text(),'двое суток')]");
    // локатор поля цвет самоката
    private final By fieldColorBlack = By.id("black");
    private final By fieldColorGrey = By.id("grey");
    // локатор поля коментарий
    private final By fieldComent = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // локатор кнопки Заказать
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM'  and contains(text(),'Заказать')]");
    // локатор заголовка формы "подтвердить заказа"
    private final By orderModalConfirm = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ'  and contains(text(),'Хотите оформить заказ')]");
    //локатор заголовка формы "Заказа оформлен"
    private final By orderModalFinal = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ'  and contains(text(),'Заказ оформлен')]");
    private final By okButton =  By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM'  and contains(text(),'Да')]");
    // методы зполнения полей формы Аренды
    public DataRentPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setFieldData(String date){
        driver.findElement(fieldData).clear();
        driver.findElement(fieldData).sendKeys(date);
    }
    public void setFieldPeriod(int i){
        driver.findElement(fieldPeriod).click();
        if (i==0){
            driver.findElement(fieldPeriodSelected1).click();
        }else {
            driver.findElement(fieldPeriodSelected2).click();
        }

    }
    public void setFieldColor(int i){
        if (i == 0) {
            driver.findElement(fieldColorBlack).click();
        }else {
            driver.findElement(fieldColorGrey).click();
        }
    }
    public void setFieldComent(String coment){
        driver.findElement(fieldComent).sendKeys(coment);
    }
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
    public void waitForLoadOrderPage() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
    }
    // ждем открытия модальной формы подтверждения заказа
    public void waitForLoadOrderModalHeader() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(orderModalConfirm));
    }
    public void clickOkButton() {
        driver.findElement(okButton).click();
    }
    public void setOrderModalFinal(){
        driver.findElement(orderModalFinal);
    }
}
