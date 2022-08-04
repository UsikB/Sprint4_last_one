package ru.yandex_praktikum_sprint4.chrome;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex_praktikum.sprint4.HomePage;

import static org.junit.Assert.assertEquals;

public class TestHomePageFaqChrome {
   private static final String EXP_FAQ_ANSWER_ITEM1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static final String EXP_FAQ_ANSWER_ITEM2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static final String EXP_FAQ_ANSWER_ITEM3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static final String EXP_FAQ_ANSWER_ITEM4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private static final String EXP_FAQ_ANSWER_ITEM5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static final String EXP_FAQ_ANSWER_ITEM6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static final String EXP_FAQ_ANSWER_ITEM7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static final String EXP_FAQ_ANSWER_ITEM8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
     WebDriver driver;

    // Тест первого вопроса
    @Test
    public void test1() {
        driver = new ChromeDriver();
    // подключаемся к странице
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        // ждем загрузки нужных нам элементов
        objHomePage.waitForLoadHomePage();
        // кликаем по куки если есть
        objHomePage.clickCookieButton();
        //скролим
        objHomePage.scrollToFaqQuestion();
        // кликаем по вопросу
        objHomePage.clickFaqQuestion1();
        objHomePage.waitForLoadText(1);
        assertEquals("не совпадает текст ответа в пункте 1",EXP_FAQ_ANSWER_ITEM1,objHomePage.getTextFaqAnswerItem1());
    }
    @After
    public void test1down() {
        // Закрываем браузер
        driver.quit();
    }
    // Тест второго вопроса
    @Test
    public void test2() {
        driver = new ChromeDriver();
        // подключаемся к странице
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        // ждем загрузки нужных нам элементов
        objHomePage.waitForLoadHomePage();
        // кликаем по куки если есть
        objHomePage.clickCookieButton();
        //скролим
        objHomePage.scrollToFaqQuestion();
        // кликаем по вопросу
        objHomePage.clickFaqQuestion2();
        objHomePage.waitForLoadText(2);
        assertEquals("не совпадает текст ответа в пункте 2",EXP_FAQ_ANSWER_ITEM2,objHomePage.getTextFaqAnswerItem2());
    }
    @After
    public void test2down() {
        // Закрываем браузер
        driver.quit();
    }
    // Тест третьего вопроса
    @Test
    public void test3() {
        driver = new ChromeDriver();
        // подключаемся к странице
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        // ждем загрузки нужных нам элементов
        objHomePage.waitForLoadHomePage();
        // кликаем по куки если есть
        objHomePage.clickCookieButton();
        //скролим
        objHomePage.scrollToFaqQuestion();
        // кликаем по вопросу
        objHomePage.clickFaqQuestion3();
        objHomePage.waitForLoadText(3);
        assertEquals("не совпадает текст ответа в пункте 3",EXP_FAQ_ANSWER_ITEM3,objHomePage.getTextFaqAnswerItem3());
    }
    @After
    public void test3down() {
        // Закрываем браузер
        driver.quit();
    }
    // Тест четвертого вопроса
    @Test
    public void test4() {
        driver = new ChromeDriver();
        // подключаемся к странице
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        // ждем загрузки нужных нам элементов
        objHomePage.waitForLoadHomePage();
        // кликаем по куки если есть
        objHomePage.clickCookieButton();
        //скролим
        objHomePage.scrollToFaqQuestion();
        // кликаем по вопросу
        objHomePage.clickFaqQuestion4();
        objHomePage.waitForLoadText(4);
        assertEquals("не совпадает текст ответа в пункте 4",EXP_FAQ_ANSWER_ITEM4,objHomePage.getTextFaqAnswerItem4());
    }
    @After
    public void test4down() {
        // Закрываем браузер
        driver.quit();
    }
    // Тест пятого вопроса
    @Test
    public void test5() {
        driver = new ChromeDriver();
        //    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // подключаемся к странице
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        // ждем загрузки нужных нам элементов
        objHomePage.waitForLoadHomePage();
        // кликаем по куки если есть
        objHomePage.clickCookieButton();
        //скролим
        objHomePage.scrollToFaqQuestion();
        // кликаем по вопросу
        objHomePage.clickFaqQuestion5();
        objHomePage.waitForLoadText(5);
        assertEquals("не совпадает текст ответа в пункте 5",EXP_FAQ_ANSWER_ITEM5,objHomePage.getTextFaqAnswerItem5());
    }
    @After
    public void test5down() {
        // Закрываем браузер
        driver.quit();
    }
    // Тест шестого вопроса
    @Test
    public void test6() {
        driver = new ChromeDriver();
        // подключаемся к странице
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        // ждем загрузки нужных нам элементов
        objHomePage.waitForLoadHomePage();
        // кликаем по куки если есть
        objHomePage.clickCookieButton();
        //скролим
        objHomePage.scrollToFaqQuestion();
        // кликаем по вопросу
        objHomePage.clickFaqQuestion6();
        objHomePage.waitForLoadText(6);
        assertEquals("не совпадает текст ответа в пункте 6",EXP_FAQ_ANSWER_ITEM6,objHomePage.getTextFaqAnswerItem6());
    }
    @After
    public void test6down(){
        // Закрываем браузер
        driver.quit();
    }
    // Тест седьмого вопроса
    @Test
    public void test7() {
        driver = new ChromeDriver();
        // подключаемся к странице
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        // ждем загрузки нужных нам элементов
        objHomePage.waitForLoadHomePage();
        // кликаем по куки если есть
        objHomePage.clickCookieButton();
        //скролим
        objHomePage.scrollToFaqQuestion();
        // кликаем по вопросу
        objHomePage.clickFaqQuestion7();
        objHomePage.waitForLoadText(7);
        assertEquals("не совпадает текст ответа в пункте 7",EXP_FAQ_ANSWER_ITEM7,objHomePage.getTextFaqAnswerItem7());
    }
    @After
    public void test7down() {
        // Закрываем браузер
        driver.quit();
    }
    // Тест восьмого вопроса
    @Test
    public void test8() {
        driver = new ChromeDriver();
        // подключаемся к странице
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        // ждем загрузки нужных нам элементов
        objHomePage.waitForLoadHomePage();
        // кликаем по куки если есть
        objHomePage.clickCookieButton();
        //скролим
        objHomePage.scrollToFaqQuestion();
        // кликаем по вопросу
        objHomePage.clickFaqQuestion8();
        objHomePage.waitForLoadText(8);
        assertEquals("не совпадает текст ответа в пункте 8",EXP_FAQ_ANSWER_ITEM8,objHomePage.getTextFaqAnswerItem8());
    }
    @After
    public void test8down() {
        // Закрываем браузер
        driver.quit();
    }
}
