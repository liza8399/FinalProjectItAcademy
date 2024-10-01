package com.itacademy.pages;

import com.itacademy.utils.DriverManager;
import com.itacademy.utils.JSExecutorUtils;
import com.itacademy.utils.Waiters;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class SearchPage {

    private final WebDriver driver;

    @FindBy(xpath ="//h2[@class='_titleText_641wy_15 ui-catalog-search-head-title']")
    private WebElement pageTitle;

    @Getter
    @FindBy(id="catalog-main")
    private WebElement catalogField;

    @FindBy(xpath=".//*[contains(@class, 'x-product-card__card x-product-card__card_catalog')]")
    private List <WebElement> foundedItems;

    @FindBy(xpath="//span[(@class='_title_pjvgk_43' and text()='Подобрали для вас')]")
    private WebElement sortBtn;

    @FindBy(xpath ="//*[@class='_root_g6flk_2']")
    private WebElement suggestionPopUp;

    @FindBy(xpath="//*[text()='Материалы']")
    private WebElement materialChoice;

    @FindBy(xpath="//*[@class='vue-recycle-scroller ready direction-vertical _scroller_n6etx_2 _root_htwrd_2 _withOutHeader_htwrd_74 _rootGroup_htwrd_7'][1]")
    private WebElement upperMaterialSuggestionPopUp;

    @FindBy(xpath="//*[@class='vue-recycle-scroller ready direction-vertical _scroller_n6etx_2 _root_htwrd_2 _withOutHeader_htwrd_74 _rootGroup_htwrd_7'][2]")
    private WebElement innerMaterialSuggestionPopUp;

    @FindBy(xpath="//*[text()='Цвет']")
    private WebElement colorChoice;

    @FindBy (xpath="//*[@class='vue-recycle-scroller ready direction-vertical _scroller_n6etx_2 _root_htwrd_2 _withHeader_htwrd_70']")
    private WebElement colorSuggestionPopUp;

    @FindBy(xpath="//*[text()='Размер']")
    private WebElement sizeChoice;

    @FindBy(xpath="//*[@class='vue-recycle-scroller ready direction-vertical _scroller_n6etx_2 _root_htwrd_2 _withOutHeader_htwrd_74']")
    private WebElement sizeSuggestionPopUp;

    @FindBy(xpath="//*[text()='Цена']")
    private WebElement priceChoice;

    @FindBy(xpath="//*[text()='Бренд']")
    private WebElement brandChoice;

    @FindBy(xpath="//*[@class='vue-recycle-scroller ready direction-vertical _scroller_n6etx_2 _root_htwrd_2 _withHeader_htwrd_70']")
    private WebElement brandSuggestionPopUp;

    @FindBy(xpath="//*[@class='_input_u3foj_9']")
    private WebElement brandInput;

    @FindBy(xpath="//*[@class='x-button x-button_primaryNewFilled x-button_48 x-button_intrinsic-width _apply_1x1qp_20']")
    private WebElement confirmSelectionBtn;

    @FindBy(xpath="//*[@class='_root_aroml_2 _label_aroml_17 x-product-card__pic x-product-card__pic-catalog x-product-card__pic x-product-card__pic-catalog']")
    private WebElement productLink;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public String getPageTitleText(){
        return pageTitle.getText();
    }


    public void sortProducts(String sortParameter) {
        sortBtn.click();
        List<WebElement> radioBtns = suggestionPopUp
                .findElements(By.xpath(".//*[contains(@class, '_root_1xdyy_2')]"));
        for (WebElement element : radioBtns) {
            if(element.getText().equals(sortParameter)){
                element.click();
                break;
            }
        }
        Waiters.wait(1000);
    }

    public void chooseMaterial(String upperMaterial1, String upperMaterial2, String innerMaterial1, String innerMaterial2) {
        materialChoice.click();
        Waiters.wait(1000);
        List<WebElement> upperMaterialChoiceElements = upperMaterialSuggestionPopUp
                .findElements(By.xpath(".//*[contains(@class, '_content_1xdyy_51')]"));
        for(WebElement element : upperMaterialChoiceElements){
            if(element.getText().equals(upperMaterial1)){
                JSExecutorUtils.click(DriverManager.getDriver(), element);
            } else if(element.getText().equals(upperMaterial2)){
                JSExecutorUtils.click(DriverManager.getDriver(), element);
            }
        }

        List<WebElement> innerMaterialChoiceElements = innerMaterialSuggestionPopUp
                .findElements(By.xpath(".//*[contains(@class, '_content_1xdyy_51')]"));
        for(WebElement element : innerMaterialChoiceElements){
            if(element.getText().equals(innerMaterial1)){
                JSExecutorUtils.click(DriverManager.getDriver(), element);
            } else if(element.getText().equals(innerMaterial2)){
                JSExecutorUtils.click(DriverManager.getDriver(), element);
            }
        }
        confirmSelectionBtn.click();
        Waiters.wait(1000);
    }

    public void chooseColor(String color) {
        colorChoice.click();
        Waiters.wait(1000);
        List<WebElement> colorList = colorSuggestionPopUp
                .findElements(By.xpath(".//*[contains(@class, '_content_1xdyy_51')]"));
        for (WebElement element : colorList) {
            if (element.getText().equals(color)) {
                JSExecutorUtils.click(DriverManager.getDriver(), element);
                break;
            }
        }
        Waiters.wait(3000);
        confirmSelectionBtn.click();

    }

    public void chooseSize(String size) {
        sizeChoice.click();
        Waiters.wait(1000);
        List<WebElement> sizeList = sizeSuggestionPopUp
                .findElements(By.xpath(".//*[contains(@class, '_content_1xdyy_51')]"));
        for (WebElement element : sizeList) {
            if (element.getText().equals(size)) {
                JSExecutorUtils.click(DriverManager.getDriver(), element);
                break;
            }
        }
        Waiters.wait(3000);
        confirmSelectionBtn.click();
        Waiters.wait(3000);
    }

    public void chooseBrand(String brand) {
        brandChoice.click();
        Waiters.wait(1000);
        brandInput.sendKeys(brand);
        Waiters.wait(1000);
        brandSuggestionPopUp.findElement(By.xpath(".//*[contains(text(), '" + brand + "')]")).click();
        Waiters.wait(5000);
        confirmSelectionBtn.click();
        Waiters.wait(3000);
    }

    public String getItemBrandInfo(int index) {

        return getFoundedItems().get(index)
                .findElement(By.xpath("//span[(@class='class=x-product-card-description__brand-name _brandName_1rcja_6 x-product-card-description__brand-name_faded')]"))
                .getText();
    }

    public String getItemTypeInfo(int index) {

        return getFoundedItems().get(index)
                .findElement(By.xpath("//span[(@class='x-product-card-description__product-name _productName_1rcja_7 x-product-card-description__product-name_faded')]"))
                .getText();
    }

    public String getItemPriceInfo(int index) {

        String itemPrice = "";

        if (!getFoundedItems().get(index)
                .findElement(By.xpath("//span[(@class='_price_1rcja_8 x-product-card-description__price-new x-product-card-description__price-WEB8507_price_bold')]"))
                .getText().isEmpty()) {
            itemPrice = getFoundedItems().get(index)
                    .findElement(By.xpath("//span[(@class='_price_1rcja_8 x-product-card-description__price-new x-product-card-description__price-WEB8507_price_bold')]"))
                    .getText();
        } else if (!getFoundedItems().get(index)
                .findElement(By.xpath("//span[(@class='x-product-card-description__price-second-old _price_1rcja_8')]"))
                .getText().isEmpty()) {
            itemPrice = getFoundedItems().get(index)
                    .findElement(By.xpath("//span[(@class='x-product-card-description__price-second-old _price_1rcja_8')]"))
                    .getText();
        } else {
            itemPrice = getFoundedItems().get(index)
                    .findElement(By.xpath("//span[(@class='_price_1rcja_8 x-product-card-description__price-old')]"))
                    .getText();
        }
        return itemPrice;
    }

    public ItemPage clickToItem(int index) {
        foundedItems.get(index).click();
        return new ItemPage(DriverManager.getDriver());
    }
}

