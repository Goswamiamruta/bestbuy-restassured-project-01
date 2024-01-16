package com.bestbuy.testsuite;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest extends TestBase {
    static ValidatableResponse response;

    @BeforeClass
    public static void response() {
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
        response.log().all();
    }

    //1. Extract the limit
    @Test
    public void test001() {

        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    //2. Extract the total
    @Test
    public void test002() {

        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + total);
        System.out.println("------------------End of Test---------------------------");

    }

    //3. Extract the name of 5th product
    @Test
    public void test003() {
        String name = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //4. Extract the names of all the products
    @Test
    public void test004() {
        List<String> allProduct = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + allProduct);
        System.out.println("------------------End of Test---------------------------");
    }

    //5. Extract the productId of all the products
    @Test
    public void test005() {
        List<String> productId = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + productId);
        System.out.println("------------------End of Test---------------------------");
    }


    //6. Print the size of the data list
    @Test
    public void test006() {
        List<String> dataSizeList = response.extract().path("data");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + dataSizeList.size());
        System.out.println("------------------End of Test---------------------------");
    }


    //7. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void test007() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //8. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
    @Test
    public void test008() {
        List<HashMap<String, ?>> model = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}.model");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + model);
        System.out.println("------------------End of Test---------------------------");
    }

    //9. Get all the categories of 8th products
    @Test
    public void test009() {
        List<String> categories = response.extract().path("data[7].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + categories.size());
        System.out.println("------------------End of Test---------------------------");
    }


    //10. Get categories of the store where product id = 150115
    @Test
    public void test010() {
        List<String> categories = response.extract().path("data[2].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + categories);
        System.out.println("------------------End of Test---------------------------");
    }


    //11. Get all the descriptions of all the products
    @Test
    public void test011() {
        List<?> descriptions = response.extract().path("data.description");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + descriptions);
        System.out.println("------------------End of Test---------------------------");
    }


    //12. Get id of all the all categories of all the products
    @Test
    public void test012() {
        List<String> categories = response.extract().path("data.categories.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + categories);
        System.out.println("------------------End of Test---------------------------");
    }


    //13. Find the product names Where type = HardGood
    @Test
    public void test033() {
        String productName = response.extract().path("data[0].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product names Where type is HardGood : " + productName);
        System.out.println("------------------End of Test---------------------------");
    }

    //14. Find the Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)
    @Test
    public void test034() {
        List<Integer> numberOfCategories = response.extract().path("data[1].categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The categories for the product is : " + numberOfCategories.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //15. Find the createdAt for all products whose price < 5.49
    @Test
    public void test035() {
        List<String> createdAt = response.extract().path("data.findAll{it.price < 5.49}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createdAt for all products whose price < 5.49 : " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }

    //16. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)”
    @Test
    public void test036() {
        List<Integer> numberOfCategories = response.extract().path("data[3].categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The categories for the product is : " + numberOfCategories.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //17. Find the manufacturer of all the products
    @Test
    public void test037() {
        List<String> manufacturer = response.extract().path("data.manufacturer");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The manufacture the product is : " + manufacturer);
        System.out.println("------------------End of Test---------------------------");
    }

    //18. Find the image of products whose manufacturer is = Energizer
    @Test
    public void test038() {
        String image = response.extract().path("data[3].image");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The image is : " + image);
        System.out.println("------------------End of Test---------------------------");
    }

    //19. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void test039() {
        List<String> createdAt = response.extract().path("data.findAll{it.price < 5.99}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createdAt for all products whose price < 5.99 : " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }

    //20. Find the uri of all the products
    @Test
    public void test040() {
        List<?> url = response.extract().path("data.url");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The url of all products is : " + url);
        System.out.println("------------------End of Test---------------------------");
    }
}