/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package struts2.test.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import struts2.test.beans.Product;
import struts2.test.beans.User;
import struts2.test.dao.ProductService;

/**
 *
 * @author Lenovo
 */
public class ProductAction extends ActionSupport{
    private int productId;
    private String productName;
    private String productMake;
    private double price;
    private int availability;
    
    
    private String msg = "";
    ProductService product=null;
    private int ctr = 0;
    ResultSet rs = null;
    Product products = new Product();
    private List<Product> productList = null;
    ProductService productService=new ProductService();
    private boolean noData = false;
    private String submitType;
    /**
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the productMake
     */
    public String getProductMake() {
        return productMake;
    }

    /**
     * @param productMake the productMake to set
     */
    public void setProductMake(String productMake) {
        this.productMake = productMake;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the availability
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * @param availability the availability to set
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }
    
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the ctr
     */
    public int getCtr() {
        return ctr;
    }

    /**
     * @param ctr the ctr to set
     */
    public void setCtr(int ctr) {
        this.ctr = ctr;
    }
    
    public List<Product> getUserList() {
        return productList;
    }

    /**
     * @param userList the userList to set
     */
    public void setUserList(List<Product> productList) {
        this.productList = productList;
    }

    /**
     * @return the noData
     */
    public boolean isNoData() {
        return noData;
    }

    /**
     * @param noData the noData to set
     */
    public void setNoData(boolean noData) {
        this.noData = noData;
    }
    public String addPoduct(){
        product =new ProductService();
        try{
            setCtr(product.addProduct(productName, productMake, price, availability));
            if (getCtr() > 0) {
                setMsg("Product Added Successfull");
            } else {
                setMsg("Some error");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return "ADDED";
    }
    
    public String getAllProduct(){
        try {
            setUserList(new ArrayList<>());
            setUserList(productService.report());
            

            if (!productList.isEmpty() ) {
                setNoData(false);
                System.out.println("Users retrieve = "+getUserList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "REPORT";
    }
    
    public String updateProduct(){
        product=new ProductService();
        try {
            if (submitType.equals("updatedata")) {
                Product pro =product.fetchProductDetails(productId);
                if (pro != null) {
                    productId = pro.getProductId();
                    productName = pro.getProductName();
                    productMake = pro.getProductMake();
                    price = pro.getPrice();
                    availability =pro.getAvailability();
                }
            } 
                else {
                System.out.println("in else part Product Name: "+productName);
                int i = product.updateProductDetails(productId, productName, productMake, price, availability);
                if (i > 0) {
                    msg = "Record Updated Successfuly";
                } else {
                    msg = "error";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "UPDATE";
    }

    /**
     * @return the submitType
     */
    public String getSubmitType() {
        return submitType;
    }

    /**
     * @param submitType the submitType to set
     */
    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }
}
