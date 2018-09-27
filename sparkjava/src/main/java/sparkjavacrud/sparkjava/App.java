package sparkjavacrud.sparkjava;

import sparkjavacrud.sparkjava.controllers.ProductController;
import sparkjavacrud.sparkjava.services.ProductService;

public class App 
{
    public static void main( String[] args )
    {
    	new ProductController(new ProductService());
    }
}
