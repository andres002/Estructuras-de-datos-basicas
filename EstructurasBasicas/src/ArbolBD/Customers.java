package ArbolBD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Customers implements Serializable{
    private ResultSet rs=null;    
    private Connection conecc;
    private Statement st=null;
    private String customerID;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String phone;
    private String fax;
    Customers(){

    }

    Customers(String customerID,  String companyName, String contactName, String contactTitle, String address, String city, String region, String postalcode, String country, String phone, String fax){
       this.customerID = customerID ;
       this.companyName = companyName;
       this.contactName = contactName;
       this.contactTitle = contactTitle;
       this.address = address ;
       this.city = city;
       this.region = region;
       this.postalCode = postalcode;
       this.country = country;
       this.phone = phone;
       this.fax = fax;

    }

    public void consultarDatos(){        
        try {
            Class.forName("com.mysql.jdbc.Driver"); //Comprobar el conector    org.gjt.mm.mysql.Driver
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conecc = DriverManager.getConnection("jdbc:mysql://localhost/practicaesd", "root","");
        } catch (SQLException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            st=conecc.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
        String instruccion="select * from customers";
        try {
            rs = st.executeQuery(instruccion); //Ejecuta el query de SQL
        } catch (SQLException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
        //nextData();
    }
    
    
    public boolean nextData(){
        try {
            if(rs.next()){
                customerID = rs.getString("CustomerID");
                companyName = rs.getString("CompanyName");
                contactName = rs.getString("ContactName");
                contactTitle = rs.getString("ContactTitle");
                address = rs.getString("Address");
                city = rs.getString("City");
                region = rs.getString("Region");
                postalCode = rs.getString("PostalCode");
                country = rs.getString("Country");
                phone = rs.getString("Phone");
                fax = rs.getString("Fax");
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public String getContactTitle(){
        return contactTitle;
    }public String getAddress(){
        return address;
    }
     public String getCity(){
        return city;
    }
    public String getPostalcode(){
        return postalCode;
    }
    public String getCountry(){
        return country;
    }
    public String getPhone(){
        return phone;
    }
    public String getFax(){
        return fax;
    }

     public String getRegion(){
        return region;
    }

  	public String getCompanyName(){
  		return companyName;
  	}
    public String getCustomerID(){
        return customerID;
    }
    public String getContactName(){
        return contactName;
    }

    public void Imprimir(){
        System.out.println("---------------------");
        System.out.println("CompanyName: " + companyName);
        /*System.out.println("CustomerID: " + customerID);
        System.out.println("ContactName: " + contactName);
        System.out.println("ContactTitle: " + contactTitle);
        System.out.println("Address: "+ address);
        System.out.println("City: "+ city);
        System.out.println("Region: "+ region);
        System.out.println("PostalCode: "+ postalCode);*/
        System.out.println("Country: "+country+"\n");
        /*System.out.println("Phone: "+phone);
        System.out.println("fax: "+fax);*/
    }   

}