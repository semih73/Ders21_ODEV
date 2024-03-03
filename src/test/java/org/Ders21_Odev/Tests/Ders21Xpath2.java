package org.Ders21_Odev.Tests;

import org.Ders21_Odev.Drivers.Driver;
import org.Ders21_Odev.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Ders21Xpath2 {
    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager = new PropertyManager();

    @BeforeSuite
    public void XpathOdev2() throws MalformedURLException {
        driver = webDriver.initializeDriver();
    }

    // Adrese gidiş
    @Test(priority = 1)
    public void sayfayaGit() {
        driver.get(propertyManager.getProperty("APP_URL2"));
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "DEMOQA");
    }

    //Add butonuna tıklama
    @Test(priority = 2)
    public void Add() {
        WebElement Add = driver.findElement(By.xpath("//button[@id='addNewRecordButton']"));
        Add.click();
        WebElement textWebtables = driver.findElement(By.xpath("//div[@id='registration-form-modal']"));
        String control = textWebtables.getText();
        Assert.assertEquals(control, "Registration Form");
    }

    //First name girişi
    @Test(priority = 3)
    public void firstName() {
        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
        firstName.click();
        firstName.sendKeys("Semih");
    }

    //Last name giriş
    @Test(priority = 4)
    public void lastName() {
        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastName.click();
        lastName.sendKeys("Dinler");
    }

    //e-mail giriş
    @Test(priority = 5)
    public void eMail() {
        WebElement eMail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        eMail.click();
        eMail.sendKeys("semih.dinler@gmail.com");
    }

    //Age giriş
    @Test(priority = 6)
    public void age() {
        WebElement age = driver.findElement(By.xpath("//input[@id='age']"));
        age.click();
        age.sendKeys("50");
    }

    //Salary giriş
    @Test(priority = 7)
    public void salary() {
        WebElement salary = driver.findElement(By.xpath("//input[@id='salary']"));
        salary.click();
        salary.sendKeys("0");
    }

    // Departman giriş
    @Test(priority = 8)
    public void department() {
        WebElement department = driver.findElement(By.xpath("//input[@id='department']"));
        department.click();
        department.sendKeys("Kalite");
    }

    //Submit
    @Test(priority = 9)
    public void submit() {
        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        submit.click();
    }

    // edit düğmesine basma ve form sayfasına gitme
    @Test(priority = 10)
    public void edit() {
        WebElement duzenle = driver.findElement(By.xpath("//span[@id='edit-record-4']"));
        duzenle.click();

    }

    // Yaş bilgisini editleme ve submit etme
    @Test(priority = 11)
    public void newAge() {
        WebElement ageEdit = driver.findElement(By.xpath("//input[@id='age']"));
        ageEdit.click();
        ageEdit.clear();
        ageEdit.sendKeys("45");

    }
    @Test(priority = 12)
    public void submitClick(){
        WebElement editSubmit = driver.findElement(By.xpath("//button[@id='submit']"));
        editSubmit.click();
    }
    @Test(priority = 13)
    public void agecontrol() {
        WebElement newage = driver.findElement(By.xpath("//div[contains(text(),'45')]"));
        String text = newage.getText();
        Assert.assertEquals(text, "45");
    }
}
