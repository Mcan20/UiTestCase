package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GeneralMethods {


    private By addToBasket = By.className("add-to-basket-button");
    private String url = "https://10minutemail.net/?lang=tr";
    private By mailText = By.id("fe_text");



    protected WebDriver driver;
    protected Actions actions;

    public GeneralMethods(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(this.driver);
    }

    public void click(By byElement, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(byElement)).click();
    }

    public void sendKeys(By byElement, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(byElement)).sendKeys(text);
    }

    public String getText(By byElement) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(byElement)).getText();
    }

    public void moveToElement(By byElement) {

        WebElement element = driver.findElement(byElement);
        String strJavaScript = "var element = arguments[0]; var mouseEventObj = document.createEvent('MouseEvents'); mouseEventObj.initEvent( 'mouseover', true, true ); element.dispatchEvent(mouseEventObj);";
        ((JavascriptExecutor) driver).executeScript(strJavaScript, element);

    }

    public void scrollToPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

    }

    public void addToBasketProduct(){
        List<WebElement> productList =  driver.findElements(addToBasket);
        productList.get(0).click();
    }



    public String takeMail(){

        driver.get(url);
        return driver.findElement(mailText).getAttribute("value");
    }




}
