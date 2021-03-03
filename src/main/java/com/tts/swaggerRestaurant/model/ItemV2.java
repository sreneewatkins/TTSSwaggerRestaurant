package com.tts.swaggerRestaurant.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

//@Data or generate constructors and getters/setters
public class ItemV2 {

    /*
    Annotations can be added to models to provide additional context to
    API responses.
     */
    @ApiModelProperty(notes = "The name of the menu item")
    private String name;
    @ApiModelProperty(notes = "The description of the menu item")
    private String description;
    @ApiModelProperty(notes = "The category of the menu item (appetizer, entree, dessert, etc)")
    private String category;

    @ApiModelProperty(notes = "The ingredients used in the menu item")
    private List<IngredientV2> ingredients;
    /*
    changing the above list to type Ingredient will cause a "breaking change".
    To handle this, we need to create a new version of our API. Version 1
    will return the original response format used by the mobile app, and
    Version 2 will return the new, enhanced format used by the web app.
    Each app will have to request the specific version that it needs,
    and the API will have to support both versions so that it returns
    the correct responses in each case.
     */

    @ApiModelProperty(notes = "The price of the menu item")
    private double price;

    @ApiModelProperty(notes = "The creation date of the menu item")
    private Date createdDate;
    @ApiModelProperty(notes = "The last updated date of the menu item")
    private Date updatedDate;

    @ApiModelProperty(notes = "Denotes if this menu item is gluten free")
    private Boolean glutenFree;
    @ApiModelProperty(notes = "Denotes if this menu item is vegetarian")
    private Boolean vegetarian;

    //constructors
    public ItemV2() {}

    public ItemV2(String name, String description, String category,
                  List<IngredientV2> ingredients, double price,
                  Date createdDate, Date updatedDate,
                  Boolean isVegetarian, Boolean isGlutenFree) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.ingredients = ingredients;
        this.price = price;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.vegetarian = isVegetarian;
        this.glutenFree = isGlutenFree;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<IngredientV2> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientV2> ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Boolean getGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(Boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }


}//end ItemV2 class
