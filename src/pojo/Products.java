package pojo;
// Generated Aug 8, 2018 2:29:58 PM by Hibernate Tools 4.3.1



/**
 * Products generated by hbm2java
 */
public class Products  implements java.io.Serializable {


     private Integer id;
     private String name;
     private float price;
     private String date;

    public Products() {
    }

    public Products(String name, float price, String date) {
       this.name = name;
       this.price = price;
       this.date = date;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public float getPrice() {
        return this.price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }




}


