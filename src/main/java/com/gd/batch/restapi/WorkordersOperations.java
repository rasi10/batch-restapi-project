package com.gd.batch.restapi;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

/**
 *
 * @author rafael
 */
public class WorkordersOperations {
    
    private final String BASE_URL = ""; //NEED TO INSERT THE BASE URL FOR THE REST API 
    
    public Response getAllWorkorders(){
        String resourceName = "workorders";
        Response getResponse = given().accept(ContentType.JSON).get(BASE_URL + resourceName);//.prettyPeek();
        return getResponse;
    }
    
    public Response getAWorkorderById(String orderId){
        String resourceName = "workorders/"+orderId;
        Response getResponse = given().accept(ContentType.JSON).get(BASE_URL + resourceName);//.prettyPeek();
        return getResponse;
    }
    public Response deleteEventById(String orderId){
        String deleteResourceName = "workorders/"+orderId;
        Response deleteResponse = delete(BASE_URL+deleteResourceName);
        return deleteResponse;
    }
    
    // I need to add a POST method for creating new workorders to use in the tests of get by id and delete by id
    // I need to add a PUT method for handling all the operations with PUT that exist on the API
}
