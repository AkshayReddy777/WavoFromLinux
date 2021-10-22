package TestUtils;

public class GenerateData {

    protected static String currentRandomEmailID;

    public static String createRandomEmailID() {
        int randomNumber = (int )(Math.random() * 1000000 + 1);
        currentRandomEmailID = "john.mird+" + String.valueOf(randomNumber) + "@gmail.com";
        System.out.println("Generated Email ID: " + currentRandomEmailID);
        return currentRandomEmailID;
    }

    public static String getCurrentRandomEmailID() {
        if (currentRandomEmailID == null) {
            createRandomEmailID();
        }
        return currentRandomEmailID;
    }
}
