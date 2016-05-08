package com.gd.batch.restapi;

import com.jayway.restassured.response.Response;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rafael
 */
public class TestSuiteEvents {
    
    public TestSuiteEvents() {
    }
    
    @Test
    public void testGetAllEvents(){
        EventsOperations eventsOperations = new EventsOperations();
        Response getResponse = eventsOperations.getAllEvents();                
        System.out.println("Status code for GET: "+ getResponse.statusCode()); //printing the statuscode.
        assertEquals("Status code should be 200",200, getResponse.statusCode());
    }
    
    @Test
    public void testGetEventByOrderId(){
        //Need to send a post to create an event.
        //Need to save the ID of the event.
        
        EventsOperations eventsOperations = new EventsOperations();
        Response getResponse = eventsOperations.getAnEventById("orderId");   //change it to the last one created             
        System.out.println("Status code for GET: "+ getResponse.statusCode()); //printing the statuscode.
        assertEquals("Status code should be 200",200, getResponse.statusCode());
    }
    
    @Test
    public void testGetEventByOrderIdInvalidOrderId(String orderId){        
        EventsOperations eventsOperations = new EventsOperations();
        Response getResponse = eventsOperations.getAnEventById("InvalidOrderID1234xyz");                
        System.out.println("Status code for GET when it does not exist: "+ getResponse.statusCode()); //printing the statuscode.
        assertEquals("Status code should be 404",404, getResponse.statusCode());
    }
    
    @Test
    public void testDeletingAnEventRecentlyCreated(){       
        //Need to send a post to create an event.
        //Need to save the ID of the event.
        
        EventsOperations eventsOperations = new EventsOperations();
        Response deleteResponse = eventsOperations.deleteEventById("orderIdOfTheLastCreated");
        System.out.println("Status code for DELETE when existing: "+ deleteResponse.statusCode());
        assertEquals("Delete method should return 204",204,deleteResponse.statusCode());
              
    }
    
    @Test
    public void testDeletingAnEventInvalidEventId(){       

        EventsOperations eventsOperations = new EventsOperations();
        Response deleteResponse = eventsOperations.deleteEventById("InvalidOrderID1234xyz");
        System.out.println("Status code for DELETE when it does not existing: "+ deleteResponse.statusCode());
        assertEquals("Delete method should return 404",404,deleteResponse.statusCode());
              
    }
}
