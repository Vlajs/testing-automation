package faker;

public class Faker extends com.github.javafaker.Faker {
    public static String fakeUsername(){
        return new Faker().name().username();
    }
    public static String fakePassword(){
        return new Faker().internet().password();
    }
    public static String fakeFirstName(){
        return new Faker().name().firstName();
    }
    public static String fakeLastName(){
        return new Faker().name().lastName();
    }
    public static String fakePostalCode(){
        return new Faker().address().zipCode();
    }
}
