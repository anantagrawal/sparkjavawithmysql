package sparkjavacrud.sparkjava.models;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="products", schema = "public")
public class Product {
	long id;
	String name;
	float price;
	
	public Product(){
		
	}
	
	public Product(long id, String name, float price){
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
