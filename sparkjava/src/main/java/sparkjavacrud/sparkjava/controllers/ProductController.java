package sparkjavacrud.sparkjava.controllers;
import static spark.Spark.*;

import sparkjavacrud.sparkjava.models.Product;
import sparkjavacrud.sparkjava.services.ProductService;
import sparkjavacrud.sparkjava.utils.JsonUtil;

public class ProductController {
	
		public ProductController(final ProductService productService) {		     
		    get("/products", (req, res) -> productService.getAllProducts(), JsonUtil.json());
		    
		    get("/products/:id", (req, res) -> {
		    	String id = req.params(":id");
		    	Product pr = productService.getProduct(Long.parseLong(id));
		    	if (pr != null) {
		    		return pr;
		    	}
		    	else{
		    		return null;
		    	}
	    	}, JsonUtil.json());
		    
		    post("/products", (req, res) -> productService.createProduct(
	    		req.queryParams("name"),
	    		Float.parseFloat(req.queryParams("price"))
	    	), JsonUtil.json());
		    
    		put("/products/:id", (req, res) -> productService.updateProduct(
	    		Long.parseLong(req.params(":id")),
	    		req.queryParams("name"),
	    		Float.parseFloat(req.queryParams("price"))
    		), JsonUtil.json());
    		
    		delete("/products/:id", (req, res) -> productService.deleteProduct(
    	    		Long.parseLong(req.params(":id"))
        		), JsonUtil.json());
    		
    		after((req, res) -> {
			  res.type("application/json");
			});
		}
}
