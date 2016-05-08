/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gd.batch.restapi;

import com.jayway.restassured.response.Response;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSuiteWorkorders {
    
    public TestSuiteWorkorders() {
    }
    
    @Test
    public void testGetAllWorkorders(){
        WorkordersOperations workordersOperations = new WorkordersOperations();
        Response getResponse = workordersOperations.getAllWorkorders();                
        System.out.println("Status code for GET: "+ getResponse.statusCode()); //printing the statuscode.
        assertEquals("Status code should be 200",200, getResponse.statusCode());
    }
    
    @Test
    public void testGetWorkorderByOrderId(){
        //Need to send a post to create a workorder.
        //Need to save the ID of the workorder.
        
        WorkordersOperations workordersOperations = new WorkordersOperations();
        Response getResponse = workordersOperations.getAWorkorderById("orderId");  //change it to the last one created              
        System.out.println("Status code for GET: "+ getResponse.statusCode()); //printing the statuscode.
        assertEquals("Status code should be 200",200, getResponse.statusCode());
    }
    
    @Test
    public void testGetWorkorderByOrderIdInvalidOrderId(String orderId){      
        WorkordersOperations workordersOperations = new WorkordersOperations();
        Response getResponse = workordersOperations.getAWorkorderById("InvalidOrderID1234xyz");              
        System.out.println("Status code for GET: "+ getResponse.statusCode()); //printing the statuscode.
        assertEquals("Status code should be 404",404, getResponse.statusCode());
    }
    
     @Test
    public void testDeletingAWorkorderRecentlyCreated(){       
        //Need to send a post to create an event.
        //Need to save the ID of the event.
        
        WorkordersOperations workordersOperations = new WorkordersOperations();
        Response deleteResponse = workordersOperations.deleteEventById("orderIdOfTheLastCreated");         
        System.out.println("Status code for DELETE when existing: "+ deleteResponse.statusCode());
        assertEquals("Delete method should return 204",204,deleteResponse.statusCode());
              
    }
    
    @Test
    public void testDeletingAnEventInvalidEventId(){       
        WorkordersOperations workordersOperations = new WorkordersOperations();
        Response deleteResponse = workordersOperations.deleteEventById("InvalidOrderID1234xyz");
        System.out.println("Status code for DELETE when it does not existing: "+ deleteResponse.statusCode());
        assertEquals("Delete method should return 404",404,deleteResponse.statusCode());
              
    }
    
}
