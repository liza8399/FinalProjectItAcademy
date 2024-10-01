package com.itacademy.pages;

import com.itacademy.utils.DriverManager;
import com.itacademy.utils.JSExecutorUtils;
import com.itacademy.utils.Waiters;
import lombok.Data;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class ItemPage {

    private final WebDriver driver;

    @FindBy(xpath="//span[@class='_value_ajirn_27 ui-product-description-attribute-inside_material']")
    private WebElement innerMaterialDescription;

    @FindBy(xpath="//span[@class='_value_ajirn_27 ui-product-description-attribute-upper_material']")
    private WebElement upperMaterialDescription;

    @FindBy(xpath="//span[@class='_value_ajirn_27 ui-product-description-attribute-color_family']")
    private WebElement colorDescription;

    @FindBy(xpath="//*[@class='_stickyContainer_1q4q9_113']")
    private WebElement itemCard;

    @FindBy(xpath="//*[text()='Выберите размер']")
    private WebElement sizeBtn;

    @FindBy(xpath="//*[@class='_dropdown_8karg_123']")
    private WebElement dropDownField;

    @FindBy(xpath="//*[@class='x-button x-button_primaryPremium x-button_48 _cartButton_vuhwd_11']")
    private WebElement addToCartBtn;

    @FindBy(xpath="//*[@class='d-modal__frame']")
    private WebElement itemWasAddedToCartFrame;

    @FindBy(xpath="//*[@class='d-modal__header']")
    private WebElement itemWasAddedToCartTitle;

    @FindBy(xpath="//*[text()='Перейти в корзину']")
    private WebElement goToTheCartBtn;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void chooseSizeOfItem(String sizeToChoose) {
        sizeBtn.click();
        List<WebElement> sizeList = dropDownField
                .findElements(By.xpath(".//*[contains(@class, '_firstRow_8karg_194')]"));
        for (WebElement element : sizeList) {
            if (element.getText().contains(sizeToChoose)) {
                JSExecutorUtils.click(DriverManager.getDriver(), element);
                break;
            }
        }
        Waiters.wait(2000);
    }

    public void clickAddToCartBtn() {
        addToCartBtn.click();
    }

    public String getItemBrandInfo(){
        return itemCard
                .findElement(By.xpath("//span[(@class='product-title__brand-name ui-product-brand-title')]"))
                .getText();
    }

    public String getItemTypeInfo(){
        return itemCard
                .findElement(By.xpath("//*[@class='_modelName_1lw0e_21']"))
                .getText();
    }

    public String getItemPriceInfo(){

        return itemCard
                .findElement(By.xpath("//span[(@aria-label='Итоговая цена')]"))
                .getText();

    }

    public CartPage clickGoToTheCartBtn() {
        goToTheCartBtn.click();
        return new CartPage(DriverManager.getDriver());
    }

//    public List<String> itemInformation(WebElement item){
//        String price = item.findElement(By.xpath("//span[@class='_price_1rcja_8 x-product-card-description__price-new x-product-card-description__price-WEB8507_price_bold']")).getText();
//        String brandName = item.findElement(By.xpath("//*[@class='x-product-card-description__brand-name _brandName_1rcja_6 x-product-card-description__brand-name_faded']")).getText();
//        String itemType =
//
//    }

}
