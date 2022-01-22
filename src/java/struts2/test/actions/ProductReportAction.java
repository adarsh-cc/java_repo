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
import struts2.test.dao.Admin;
import struts2.test.dao.ProductService;

/**
 *
 * @author Lenovo
 */
public class ProductReportAction extends ActionSupport{
        private static final long serialVersionUID = 6329394260276112660L;
    ResultSet rs = null;
    Product products = null;
    private List<Product> productList = null;
    ProductService productService=new ProductService();
    private boolean noData = false;

//    @Override
//    public String execute() throws Exception {
//        try {
//            setUserList(new ArrayList<>());
//            setUserList(productService.report());
//            
//
//            if (!productList.isEmpty() ) {
//                setNoData(false);
//                System.out.println("Users retrieve = "+getUserList().size());
//                System.out.println("setting nodata=false");
//            } else {
//                setNoData(true);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "REPORT";
//    }
    
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

    /**
     * @return the userList
     */
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

}
