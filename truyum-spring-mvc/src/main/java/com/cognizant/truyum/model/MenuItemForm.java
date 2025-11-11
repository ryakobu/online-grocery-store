package com.cognizant.truyum.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;


public class MenuItemForm {

	public MenuItemForm() {
		// TODO Auto-generated constructor stub
	}
	private long id;
	@Size(min=2,message="Title is required and should be 2 to 65 characters")
	
    private String name;
    @Min(value=0, message="must be equal or greater than 0")  
    private float price;
    private boolean active;
    
    private String dateOfLaunch;
    private String category;
    private boolean freeDelivery;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getDateOfLaunch() {
		return dateOfLaunch;
	}
	public void setDateOfLaunch(String dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isFreeDelivery() {
		return freeDelivery;
	}
	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}
	@Override
	public String toString() {
		return "MenuItemForm [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active
				+ ", dateOfLaunch=" + dateOfLaunch + ", category=" + category + ", freeDelivery=" + freeDelivery + "]";
	}
}
