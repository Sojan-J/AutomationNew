package com.naveenAutomationLab.naveenAutomationLabFrameWork.Utils;

public enum Browsers {
	CHROME("Chrome"),
	EDGE("Edge"),
	FIREFOX("Firefox"),
	SAFARI("Safari");
	String nameOfBrowser;
	Browsers(String nameOfBrowser){
		this.nameOfBrowser=nameOfBrowser;
	}
	public String getNameOfBrowser() {
		return nameOfBrowser;
	}
	

}
