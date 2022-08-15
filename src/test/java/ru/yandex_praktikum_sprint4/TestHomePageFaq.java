package ru.yandex_praktikum_sprint4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex_praktikum.sprint4.HomePage;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestHomePageFaq {
    private static final String EXP_FAQ_ANSWER_ITEM1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static final String EXP_FAQ_ANSWER_ITEM2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static final String EXP_FAQ_ANSWER_ITEM3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static final String EXP_FAQ_ANSWER_ITEM4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private static final String EXP_FAQ_ANSWER_ITEM5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static final String EXP_FAQ_ANSWER_ITEM6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static final String EXP_FAQ_ANSWER_ITEM7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static final String EXP_FAQ_ANSWER_ITEM8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    WebDriver driver;
    HomePage objHomePage = new HomePage(driver);

    public TestHomePageFaq(String choosedDriver) {
        if (choosedDriver.equals("Chrome")) {
            driver = new ChromeDriver();
        } else if (choosedDriver.equals("FireFox")) {
            driver = new FirefoxDriver();
        }
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Chrome"},
                {"FireFox"},
        };
    }

    @Before
    public void setUp() {
        driver.get(objHomePage.getMainPageLink());
    }

    // Тест первого вопроса
    @Test
    public void testFaqQuestion1() {
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
        assertEquals("не совпадает текст ответа в пункте 1", EXP_FAQ_ANSWER_ITEM1, objHomePage.getTextFaqAnswerItem1());
    }

    // Тест второго вопроса
    @Test
    public void testFaqQuestion2() {
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
        assertEquals("не совпадает текст ответа в пункте 2", EXP_FAQ_ANSWER_ITEM2, objHomePage.getTextFaqAnswerItem2());
    }

    // Тест третьего вопроса
    @Test
    public void testFaqQuestion3() {
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
        assertEquals("не совпадает текст ответа в пункте 3", EXP_FAQ_ANSWER_ITEM3, objHomePage.getTextFaqAnswerItem3());
    }

    // Тест четвертого вопроса
    @Test
    public void testFaqQuestion4() {
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
        assertEquals("не совпадает текст ответа в пункте 4", EXP_FAQ_ANSWER_ITEM4, objHomePage.getTextFaqAnswerItem4());
    }

    // Тест пятого вопроса
    @Test
    public void testFaqQuestion5() {
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
        assertEquals("не совпадает текст ответа в пункте 5", EXP_FAQ_ANSWER_ITEM5, objHomePage.getTextFaqAnswerItem5());
    }

    // Тест шестого вопроса
    @Test
    public void testFaqQuestion6() {
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
        assertEquals("не совпадает текст ответа в пункте 6", EXP_FAQ_ANSWER_ITEM6, objHomePage.getTextFaqAnswerItem6());
    }

    // Тест седьмого вопроса
    @Test
    public void testFaqQuestion7() {
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
        assertEquals("не совпадает текст ответа в пункте 7", EXP_FAQ_ANSWER_ITEM7, objHomePage.getTextFaqAnswerItem7());
    }

    // Тест восьмого вопроса
    @Test
    public void testFaqQuestion8() {
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
        assertEquals("не совпадает текст ответа в пункте 8", EXP_FAQ_ANSWER_ITEM8, objHomePage.getTextFaqAnswerItem8());
    }

    @After
    public void tearDown() {
        // Закрываем браузер
        driver.quit();
    }
}
