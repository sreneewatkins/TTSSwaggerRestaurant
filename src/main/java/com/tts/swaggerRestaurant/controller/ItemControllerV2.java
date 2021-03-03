package com.tts.swaggerRestaurant.controller;

import com.tts.swaggerRestaurant.model.ItemV1;
import com.tts.swaggerRestaurant.model.ItemV2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
Moving onto the controller, there are annotations (@Api) the can be added
to enhance the display of the endpoints.
To add a description to a controller, we add the following annotation to
the top of the controller class, directly below the @RestController
annotation. The description appears next to the controller name. This is
useful when an application has multiple controllers, where each
controller has a specific responsibility.
 */
@RequestMapping("/v2")
@Api(value="menuitems", description="Operations pertaining to Menu Items")
@RestController
public class ItemControllerV2 {

    /*
    Create endpoint in controller that returns default data set (ie an
    empty List of Items)
    To add a description to a controller method, we can use the
    @ApiOperation annotation, as shown in an earlier example. This
    annotation takes in a value for the description, as well as the
    response type.
    If the response type is a collection, then a third parameter can be
    added: responseContainer="".
    We can also describe the meaning of possible HTTP response codes in
    the context of our application by adding an additional annotation to
    the controller method. This helps provide more clarity to someone
    trying to understand our API. @ApiResponses
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved menu items"),
            @ApiResponse(code = 401, message = "You are not authorized to view the menu items")
    })
    @ApiOperation(value = "Get all menu items", response = ItemV2.class,
            responseContainer = "List")
    @GetMapping("/item/all")
    public ResponseEntity<List<ItemV2>> getAllItems() {
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

}//end ItemControllerV2 class
