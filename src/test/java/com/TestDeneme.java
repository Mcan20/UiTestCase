package com;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestDeneme extends BaseTest{

    private By Elektronik = By.cssSelector("a[href='/butik/liste/elektronik']");
    private By tvAndSes = By.partialLinkText("TV & Görüntü & Ses");
    private By AddToBasket = By.className("btn Basket_CheckoutButton");
    private By basketBtn = By.className("account-basket");
    private By count = By.className("counter-content");
    private By confirmButton = By.className("btn Basket_CheckoutButton");
    private By signUp = By.className("q-secondary q-button-medium q-button tab button right");
    GeneralMethods generalMethods;

    @Test
    public void TestOne(){
    GeneralMethods generalMethods = new GeneralMethods(webDriver);
    generalMethods.moveToElement(Elektronik);
    generalMethods.click(tvAndSes,5);
    generalMethods.addToBasketProduct();
    generalMethods.click(basketBtn,5);
    webDriver.findElement(count);

    if(webDriver.findElement(count).getAttribute("value").toString().equals("1")){
        generalMethods.click(confirmButton,5);
        generalMethods.click(signUp,5);
    }else{
        return;
    }

        //webDriver.findElement(By.)

    }
}
