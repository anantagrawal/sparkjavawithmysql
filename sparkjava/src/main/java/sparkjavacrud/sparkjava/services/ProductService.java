package sparkjavacrud.sparkjava.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import sparkjavacrud.sparkjava.models.Product;

public class ProductService {
	
	  JDBCConnection jdbcConnection; 
	  
	  public ProductService(){
		  jdbcConnection = new JDBCConnection();
	  }
	  
	  public List<Product> getAllProducts() {
		  List<Product> productData = new ArrayList<>();
		  try{
			  PreparedStatement ps = jdbcConnection.getConnnection().prepareStatement(
			  "select id, name, price from product.products");
			  ResultSet rs = ps.executeQuery();
			  while (rs.next()) {
				  Product product = new Product();
				  product.setId(Long.parseLong(rs.getString("id")));
				  product.setName(rs.getString("name"));
				  product.setPrice(Float.parseFloat(rs.getString("price")));
				  product.setPrice(Float.parseFloat(rs.getString("price")));
				  productData.add(product);
			  }
		  }
		  catch (SQLException e) {
			  e.printStackTrace();
		  }
		  finally{
			  try{
				  jdbcConnection.closeConnection();
			  }
			  catch(Exception ex){
				  
			  }
		  }
		  return productData;
	  }
	   
	  public Product getProduct(Long id) {
		  Product product = null;
		  try{
			  PreparedStatement ps = jdbcConnection.getConnnection().prepareStatement(
			  "select id, name, price from product.products where id=" + id);
			  ResultSet rs = ps.executeQuery();
			  if(rs.next())
				  product = new Product(Long.parseLong(rs.getString("id")), rs.getString("name"), Float.parseFloat(rs.getString("price")));
		  }
		  catch (SQLException e) {
			  e.printStackTrace();
		  }
		  finally{
			  try{
				  jdbcConnection.closeConnection();
			  }
			  catch(Exception ex){
				  
			  }
		  }
		  return product;
	  }
	 
	  public boolean createProduct(String name, float price) {
		  try{
			  PreparedStatement ps = jdbcConnection.getConnnection().prepareStatement(
			  "insert into product.products(name, price) values(\"" + name + "\"," + price + ")");
			  int rs = ps.executeUpdate();
			  if(rs > 0){
				  return true;
			  }
		  }
		  catch (SQLException e) {
			  e.printStackTrace();
		  }
		  finally{
			  try{
				  jdbcConnection.closeConnection();
			  }
			  catch(Exception ex){
				  
			  }
		  }
	      return false;
	  }
	
	  public boolean updateProduct(long id, String name, float price) {  
		  try{
			  PreparedStatement ps = jdbcConnection.getConnnection().prepareStatement(
			  "update product.products SET name=\"" + name + "\"," + "price=" + price +  " where id=" + id);
			  int rs = ps.executeUpdate();
			  if(rs > 0){
				  return true;
			  }
		  }
		  catch (SQLException e) {
			  e.printStackTrace();
		  }
		  finally{
			  try{
				  jdbcConnection.closeConnection();
			  }
			  catch(Exception ex){
				  
			  }
		  }
	      return false;
	  }
	  
	  public boolean deleteProduct(Long id) {
		  try{
			  PreparedStatement ps = jdbcConnection.getConnnection().prepareStatement(
			  "delete from product.products where id=" + id);
			  int rs = ps.executeUpdate();
			  if(rs > 0){
				  return true;
			  }
		  }
		  catch (SQLException e) {
			  e.printStackTrace();
		  }
		  finally{
			  try{
				  jdbcConnection.closeConnection();
			  }
			  catch(Exception ex){
				  
			  }
		  }
	      return false;
	  }
}
