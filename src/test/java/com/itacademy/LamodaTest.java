package com.itacademy;

import com.itacademy.pages.*;
import com.itacademy.utils.DriverManager;
import com.itacademy.utils.Waiters;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Log4j2
public class LamodaTest extends BaseTest {

    @Test
    public void signInTest(){
        DriverManager.getDriver().get("https://www.lamoda.by/");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.acceptCookies();

        LoginPage loginPage = homePage.loginBtnClick();;
        loginPage.checkLoginPageTitle();
        loginPage.sendEmailKeysToEmailField("123@gmail.com");
        Waiters.wait(5000);
        loginPage.sendPasswordKeysToPasswordField("123456");
        loginPage.clickSubmitButton();
        String failedLoginErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(failedLoginErrorMessage, "Неверный логин или пароль.");
    }

    @Test
    public void searchTest(){
        DriverManager.getDriver().get("https://www.lamoda.by/");
        DriverManager.getDriver().manage().window().maximize();
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.acceptCookies();
        homePage.sendKeysToSearchInputField("рубашка женская");

        SearchPage searchPage = homePage.searchBtnClick();
        Assert.assertEquals(searchPage.getPageTitleText(), "Товары по запросу «рубашка женская»");
        Assert.assertTrue(searchPage.getCatalogField().isDisplayed());
        Assert.assertNotEquals(searchPage.getFoundedItems().size(), 0);
    }

    @Test
    public void materialAndColorFiltersWorkTest() {
        DriverManager.getDriver().get("https://www.lamoda.by/");
        DriverManager.getDriver().manage().window().maximize();
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.acceptCookies();
        homePage.sendKeysToSearchInputField("кроссовки женские");

        SearchPage searchPage = homePage.searchBtnClick();
        List<String> upperMaterials = new ArrayList<>(List.of("кожа", "замша"));
        List<String> innerMaterials = new ArrayList<>(List.of("текстиль", "хлопок"));
        searchPage.chooseMaterial(upperMaterials.get(0),upperMaterials.get(1),innerMaterials.get(0),innerMaterials.get(1));
        String color = "серый";
        searchPage.chooseColor(color);

        ItemPage itemPage = searchPage.clickToItem(0);
        Set<String> acquiredUpperMaterials = Set.of(itemPage.getUpperMaterialDescription().getText().split(", "));
        boolean isOneOfUpperPresent = upperMaterials.retainAll(acquiredUpperMaterials);
        Set<String> acquiredInnerMaterials = Set.of(itemPage.getInnerMaterialDescription().getText().split(", "));
        boolean isOneOfInnerPresent = innerMaterials.retainAll(acquiredInnerMaterials);

        Assert.assertTrue(isOneOfUpperPresent);
        Assert.assertTrue(isOneOfInnerPresent);
        Assert.assertTrue(itemPage.getColorDescription().getText().contains(color));
    }



}
