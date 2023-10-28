package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    @DisplayName("Успешный поиск в википедии")
    void successfulSearchTest() {
        step("Выполняем поиск", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });

        step("Проверяем результат", () ->
                $$(className("android.widget.TextView")).shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("При открытии статьи отображается ошибка")
    void successfulWikiSearchTest() {
        step("Выполняем поиск", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Messi");
        });

        step("Проверка наличия контента в результатах Поиска", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0)));

        step("Открыть первую статью", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_container")).first().click());

        step("Отображается ошибка", () -> {
            $(id("org.wikipedia.alpha:id/view_wiki_error_text")).shouldBe(visible);
        });
    }
}