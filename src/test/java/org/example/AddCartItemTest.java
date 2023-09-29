package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AddCartItemTest {
    public static void main(String[] args){
        try {
            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();
            // maximize the driver
            driver.manage().window().maximize();
            // to open the url
            driver.get("https://qacartpage.ccbp.tech/");

            // search a input using contains function
            WebElement searchInput=driver.findElement(By.xpath("//input[contains(@id,'cartItemTextInput')]"));
            searchInput.sendKeys("Pencil");
            // enter the add button using text() method
            WebElement addText=driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
            addText.click();
            // enter the second input
            WebElement searchInput1=driver.findElement(By.xpath("//input[contains(@id,'cartItemTextInput')]"));
            searchInput1.sendKeys("Mobile");
            //enter the add button using text() method
            WebElement addText1=driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
            addText1.click();
            // enter the input is a third
            WebElement searchInput2=driver.findElement(By.xpath("//input[contains(@id,'cartItemTextInput')]"));
            searchInput2.sendKeys("Shoes");
            // enter add button using text() method
            WebElement addText2=driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
            addText2.click();
            // count the number of elements
            List<WebElement>textFindElement=driver.findElements(By.xpath("//li[starts-with(@id,'cart-item')]"));

            // to check the current cart item and expected cart item
            if(textFindElement.size()==3){
                System.out.println("Cart items count is correct: "+textFindElement.size());
            }else{
                System.out.println("Cart items count is not correct");
            }
            WebElement firstItem = textFindElement.get(0);
            WebElement secondItem = textFindElement.get(1);
            WebElement thirdItem = textFindElement.get(2);
            // Verify whether the names are in the same order as we added or not
            String firstItemName = firstItem.findElement(By.xpath("//li[contains(@id,'cart-item-1')]")).getText();
            String secondItemName = secondItem.findElement(By.xpath("//li[contains(@id,'cart-item-2')]")).getText();
            String thirdItemName = thirdItem.findElement(By.xpath("//li[contains(@id,'cart-item-3')]")).getText();
            // If the order matches, print "Items are in the correct order"

            if (firstItemName.equals("Pencil") && secondItemName.equals("Mobile") && thirdItemName.equals("Shoes")) {
                System.out.println("Items are in the correct order");
            } else {
                System.out.println("Items are not in the correct order");
            }
            // Close the browser window
            driver.quit();







        }catch (Exception e){
            System.out.println("Hi venkatesh please check your code exception error:"+e.getMessage());
        }
    }
}
