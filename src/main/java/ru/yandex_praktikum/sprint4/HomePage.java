package ru.yandex_praktikum.sprint4;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    private String mainPageLink = "https://qa-scooter.praktikum-services.ru/";
    // локатор кнопки " Да все привыкли" куки
    private By cookieButton = By.id("rcc-confirm-button");
    //локатор списка  «Вопросы о важном», по нему будем ждать загрузки страницы и скролл
    private By faqQuestion = By.className("accordion__button");
    //локатор пункт 1 выпадающего списока в разделе «Вопросы о важном»
    private By faqQuestionItem1 = By.id("accordion__heading-0");
    //локатор пункт 2 выпадающего списока в разделе «Вопросы о важном»
    private By faqQuestionItem2 = By.id("accordion__heading-1");
    //локатор пункт 3 выпадающего списока в разделе «Вопросы о важном»
    private By faqQuestionItem3 = By.id("accordion__heading-2");
    //локатор пункт 4 выпадающего списока в разделе «Вопросы о важном»
    private By faqQuestionItem4 = By.id("accordion__heading-3");
    //локатор пункт 5 выпадающего списока в разделе «Вопросы о важном»
    private By faqQuestionItem5 = By.id("accordion__heading-4");
    //локатор пункт 6 выпадающего списока в разделе «Вопросы о важном»
    private By faqQuestionItem6 = By.id("accordion__heading-5");
    //локатор пункт 7 выпадающего списока в разделе «Вопросы о важном»
    private By faqQuestionItem7 = By.id("accordion__heading-6");
    //локатор пункт 8 выпадающего списока в разделе «Вопросы о важном»
    private By faqQuestionItem8 = By.id("accordion__heading-7");


    //локатор ответ пункта 1 выпадающего списока в разделе «Вопросы о важном»
    private final By faqAnswerItem1 = By.xpath(".//div[@id = 'accordion__panel-0']/p");
    //локатор ответ пункта 2 выпадающего списока в разделе «Вопросы о важном»
    private final By faqAnswerItem2 = By.xpath(".//div[@id = 'accordion__panel-1']/p");
    //локатор ответ пункта 3 выпадающего списока в разделе «Вопросы о важном»
    private final By faqAnswerItem3 = By.xpath(".//div[@id = 'accordion__panel-2']/p");
    //локатор ответ пункта 4 выпадающего списока в разделе «Вопросы о важном»
    private final By faqAnswerItem4 = By.xpath(".//div[@id = 'accordion__panel-3']/p");
    //локатор ответ пункта 5 выпадающего списока в разделе «Вопросы о важном»
    private final By faqAnswerItem5 = By.xpath(".//div[@id = 'accordion__panel-4']/p");
    //локатор ответ пункта 6 выпадающего списока в разделе «Вопросы о важном»
    private final By faqAnswerItem6 = By.xpath(".//div[@id = 'accordion__panel-5']/p");
    //локатор ответ пункта 7 выпадающего списока в разделе «Вопросы о важном»
    private final By faqAnswerItem7 = By.xpath(".//div[@id = 'accordion__panel-6']/p");
    //локатор ответ пункта 8 выпадающего списока в разделе «Вопросы о важном»
    private final By faqAnswerItem8 = By.xpath(".//div[@id = 'accordion__panel-7']/p");

    // локатор копки заказать вверху страницы
    private final By orderButtonUpPage = By.className("Button_Button__ra12g");
    // локатор копки заказать снизу страницы
    private final By orderButtonDownPageMidle = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    //конструктор класса HomePage
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMainPageLink() {
        return mainPageLink;
    }

    // ******************************** методы для ЗАДАНИЯ 1*********************************************//
    // проверяем наличие кнопки Куки если есть то нажимаем
    public void clickCookieButton() {
        // получаем список элементов,если он не пустой
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(cookieButton)).click();
    }

    // метод ожидания кликабильности списка «Вопросы о важном»
    public void waitForLoadHomePage() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(faqQuestion));
    }

    // метод ожидания загрузки списка «Вопросы о важном»
    public void waitForLoadText(int i) {
        By element = null;
        switch (i) {
            case 1:
                element = faqAnswerItem1;
                break;
            case 2:
                element = faqAnswerItem2;
                break;
            case 3:
                element = faqAnswerItem3;
                break;
            case 4:
                element = faqAnswerItem4;
                break;
            case 5:
                element = faqAnswerItem5;
                break;
            case 6:
                element = faqAnswerItem6;
                break;
            case 7:
                element = faqAnswerItem7;
                break;
            case 8:
                element = faqAnswerItem8;
        }
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    // метод скролинга до последнего элемента списка «Вопросы о важном»
    public void scrollToFaqQuestion() {
        WebElement element = driver.findElement(faqQuestionItem8);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
    }

    // метод кликает по вопросу  из выпадающего списка
    public void clickFaqQuestion1() {
        driver.findElement(faqQuestionItem1).click();
    }

    public void clickFaqQuestion2() {
        driver.findElement(faqQuestionItem2).click();
    }

    public void clickFaqQuestion3() {
        driver.findElement(faqQuestionItem3).click();
    }

    public void clickFaqQuestion4() {
        driver.findElement(faqQuestionItem4).click();
    }

    public void clickFaqQuestion5() {
        driver.findElement(faqQuestionItem5).click();
    }

    public void clickFaqQuestion6() {
        driver.findElement(faqQuestionItem6).click();
    }

    public void clickFaqQuestion7() {
        driver.findElement(faqQuestionItem7).click();
    }

    public void clickFaqQuestion8() {
        driver.findElement(faqQuestionItem8).click();
    }

    // метод получает текст ответа при нажатии на вопрос
    public String getTextFaqAnswerItem1() {
        return driver.findElement(faqAnswerItem1).getText();
    }

    public String getTextFaqAnswerItem2() {
        return driver.findElement(faqAnswerItem2).getText();
    }

    public String getTextFaqAnswerItem3() {
        return driver.findElement(faqAnswerItem3).getText();
    }

    public String getTextFaqAnswerItem4() {
        return driver.findElement(faqAnswerItem4).getText();
    }

    public String getTextFaqAnswerItem5() {
        return driver.findElement(faqAnswerItem5).getText();
    }

    public String getTextFaqAnswerItem6() {
        return driver.findElement(faqAnswerItem6).getText();
    }

    public String getTextFaqAnswerItem7() {
        return driver.findElement(faqAnswerItem7).getText();
    }

    public String getTextFaqAnswerItem8() {
        return driver.findElement(faqAnswerItem8).getText();
    }

    // ******************************** методы для ЗАДАНИЯ 2*********************************************//
    // метод ожидания кликабильности Заказать сверху
    public void waitForLoadOrderButtonUpPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(orderButtonUpPage));
    }
    // клик по кнопке Заказать вверху
    public void clickOrderButtonUpPage() {
        driver.findElement(orderButtonUpPage).click();
    }
    //скрол до конпки Заказать снизу
    public void scrollToButtonDownPage() {
        WebElement element = driver.findElement(orderButtonDownPageMidle);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
    }
    // метод ожидания кликабильности Заказать снизу
    public void waitForLoadOrderButtonDownPage() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(orderButtonDownPageMidle));
    }
    // клик по кнопке Заказать снизу
    public void clickOrderButtonDownPage() {
        driver.findElement(orderButtonDownPageMidle).click();
    }
}

