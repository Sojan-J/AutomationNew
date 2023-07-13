package com.naveenAutomationLab.naveenAutomationLabFrameWork.Utils;

public enum Enviornment {
	DEV("Dev","https://naveenautomationlabsdev.com/opencart/index.php?route=common/home"),
	STAGE("Stage","https://naveenautomationlabsstage.com/opencart/index.php?route=common/home"),
	QA("qa","https://naveenautomationlabsqa.com/opencart/index.php?route=common/home"),
	PRODUCTION("Production","https://naveenautomationlabs.com/opencart/index.php?route=common/home");
	
	String env;
	String url;

	private Enviornment(String env, String url) {
		this.env = env;
		this.url = url;

	}

	public String getEnv() {
		return env;
	}

	public String getUrl() {
		return url;
	}

	}


