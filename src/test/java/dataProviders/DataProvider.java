package dataProviders;

import faker.Faker;
import property.PropertyManager;

public class DataProvider{
    @org.testng.annotations.DataProvider(name = "LoginSet")
    public Object[][] loginSet(){
        return new Object[][]{
                {PropertyManager.getInstance().getValidUsername(), PropertyManager.getInstance().getValidPassword(), "Product"},
                {"problem_user", "secret_sauce", "Products"},
                {"performance_glitch_user", "secret_sauce", "Products"}
        };
    }
    @org.testng.annotations.DataProvider(name = "FailedLoginSet")
    public Object[][] failedLoginSet(){
        return new Object[][] {
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {Faker.fakeUsername(), Faker.fakePassword(), "Epic sadface: Username and password do not match any user in this service"},
                {"", "", "Epic sadface: Username is required"}
        };
    }
}
