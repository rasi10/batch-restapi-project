package com.gd.batch.restapi;


import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;


public class EventsOperations {
    
    private final String BASE_URL = ""; //INSERT THE BASE URL TO REST API FINISHING WITH '/'
    
    public Response getAllEvents(){
        String resourceName = "events";
        Response getResponse = given().accept(ContentType.JSON).get(BASE_URL + resourceName);//.prettyPeek();
        return getResponse;
    }
    
    public Response getAnEventById(String orderId){
        String resourceName = "events/"+orderId;
        Response getResponse = given().accept(ContentType.JSON).get(BASE_URL + resourceName);//.prettyPeek();
        return getResponse;
    }
    public Response deleteEventById(String orderId){
        String deleteResourceName = "events/"+orderId;
        Response deleteResponse = delete(BASE_URL+deleteResourceName);
        return deleteResponse;
    }
    
    //I need to add a method for creating new events so that i can create when I getby id and when deleting by id.
}
