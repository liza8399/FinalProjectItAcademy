package com.itacademy.uitests;

import com.itacademy.pages.ItemPage;
import com.itacademy.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SearchTest extends BaseTest {

    @Test
    public void searchTest(){

        homePage.sendKeysToSearchInputField("рубашка женская");

        SearchPage searchPage = homePage.searchBtnClick();
        Assert.assertEquals(searchPage.getPageTitleText(), "Товары по запросу «рубашка женская»");
        Assert.assertTrue(searchPage.getCatalogField().isDisplayed());
        Assert.assertNotEquals(searchPage.getFoundedItems().size(), 0);
    }

    @Test
    public void searchWithFiltersTest() {

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
