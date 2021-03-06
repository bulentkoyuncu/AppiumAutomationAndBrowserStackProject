package com.mycompany.automation.pages;

import com.mycompany.automation.utils.ConfigurationReader;
import com.mycompany.automation.utils.Driver;
import com.mycompany.automation.utils.MobileUtils;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class LoginPage {

    //ios - iOSXCUITFindBy
    @AndroidFindBy(id = "com.etsy.android:id/btn_link")
    private MobileElement getStartedBtn;

    @AndroidFindBy(id = "com.etsy.android:id/edit_username")
    private MobileElement userNameInput;

    @AndroidFindBy(id = "com.etsy.android:id/edit_password")
    private MobileElement passwordInput;

    @AndroidFindBy(id = "com.etsy.android:id/button_signin")
    private MobileElement signInBtn;

    public LoginPage(){
        // in Appium, we need to use AppiumFieldDecorator to enable @FindBY annotations
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    /**
     * this method does login
     */
    public void login(){
        String email = ConfigurationReader.getProperty("user.email");
        String password = ConfigurationReader.getProperty("user.password");
        MobileUtils.waitFor(3000);
        userNameInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInBtn.click();
        MobileUtils.waitFor(3000);
    }

    public void clickGetStarted() {
        MobileUtils.clickWithWait(getStartedBtn);
    }
}
