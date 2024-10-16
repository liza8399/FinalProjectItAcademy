package com.itacademy.uitests;

import com.itacademy.pages.CartPage;
import com.itacademy.pages.ItemPage;
import com.itacademy.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void addItemToCartTest(){


        homePage.sendKeysToSearchInputField("пальто мужское");

        SearchPage searchPage = homePage.searchBtnClick();
        searchPage.sortProducts("Сначала дешевле");
        searchPage.chooseSize("52");
        searchPage.chooseBrand();

        ItemPage itemPage = searchPage.clickToItem(0);
        String itemBrandInfo = itemPage.getItemBrandInfo();
        String itemTypeInfo = itemPage.getItemTypeInfo();
        String itemPriceInfo = itemPage.getItemPriceInfo();
        itemPage.chooseSizeOfItem("52");
        itemPage.clickAddToCartBtn();
        Assert.assertTrue(itemPage.getItemWasAddedToCartFrame().isDisplayed());
        Assert.assertEquals(itemPage.getItemWasAddedToCartTitle().getText(), "Товар добавлен в корзину");

        CartPage cartPage = itemPage.clickGoToTheCartBtn();
        Assert.assertEquals(cartPage.getPriceInTheCart().getText(), itemPriceInfo);
        Assert.assertTrue(cartPage.getItemTitle().getText().contains(itemBrandInfo));
        Assert.assertTrue(cartPage.getItemTitle().getText().contains(itemTypeInfo));
    }
}
