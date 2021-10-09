package com.Maven_Oct_Project;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtable_with_Maven {
	public static int indexOfmax, indexOfmin;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pooma\\eclipse-workspace\\Seletrial\\drive\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/men-tshirts");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<WebElement> discountprice = driver.findElements(
				By.xpath("//span[@class='product-strike']//preceding-sibling::span[@class='product-discountedPrice']"));
		List<Integer> pricelist = new ArrayList<>();
		for (int i = 0; i < discountprice.size(); i++) {
			String text = discountprice.get(i).getText().replace("Rs. ", "");
			// System.out.println(text);
			int values = Integer.parseInt(text);
			pricelist.add(values);
		}
		System.out.println(pricelist);
		int listsize = pricelist.size();
		System.out.println("List size:" + listsize);
		System.out.println("maximum price : " + Collections.max(pricelist));
		System.out.println("maximum price : " + Collections.min(pricelist));
		//Integer max = Collections.max(pricelist);
		//Integer min = Collections.min(pricelist);
		for (int i = 0; i < listsize; i++) {
			if (pricelist.get(i).equals(1299)) {
				indexOfmax = i;
				//System.out.println("index of maximum price : " + indexOfmax);
				discountprice.get(i).click();
			} //else if (pricelist.get(i).equals(min)) {
				//indexOfmin = i;
			//	System.out.println("index of maximum price : " + indexOfmin);
				//discountprice.get(i).click();
			}

		}

	}





