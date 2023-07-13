package com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naveenAutomationLab.naveenAutomationLabFrameWork.base.TestBase;

public class MyWishList extends TestBase{
	//create structure of the table using enum class
	public enum myWishListTableHead {
		IMAGE("Image"),
		PRODUCT_NAME("Product Name"),
		MODEL("Model"),
		STOCK("Stock"),
		UNIT_PRICE("Unit Price"),
		ACTION("Action");
		String value;
		private myWishListTableHead(String value) {
		this.value=value;
		}		
	}
	// create mehtod that returns the index of the column we are interested
	private int getIndexOfColumn(myWishListTableHead columnName) {
		List<WebElement> headers = wd.findElements(By.cssSelector("table.table thead tr td"));
		for (WebElement headerElement : headers) {
			if (headerElement.getText().equals(columnName.value)) {
				return headers.indexOf(headerElement);
			}
			
		}
		return -1;
	}
	public WebElement getCellElementFromTable(String modelName,myWishListTableHead column) {
		int columnIndex=getIndexOfColumn(column);
		if(columnIndex<0) {
			throw new NoSuchElementException();
		}
		List<WebElement> rowsWebElements=wd.findElements(By.cssSelector("div.table-responsive>table>tbody>tr"));
		for(int i=0;i<rowsWebElements.size();i++) {
			List<WebElement>cells=rowsWebElements.get(i).findElements(By.cssSelector("td"));
			if(cells.get(2).getText().equals(modelName)) {
				return cells.get(columnIndex);
			}
			
		}
		return null;
	}

}
