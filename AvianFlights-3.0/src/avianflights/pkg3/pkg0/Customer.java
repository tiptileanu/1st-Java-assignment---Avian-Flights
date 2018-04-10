
package avianflights.pkg3.pkg0;


public class Customer {

    //variables declarations to store details needed from each customer
    private String fn, sn, dob, add, tel, email, ppNum;

    //variable needed to store aquisition price of tickets
    private double paidPrice;

    //constructor for Customer class
    public Customer(String fn, String sn, String dob, String add, String tel, String email, String ppNum) {
        this.fn = fn;
        this.sn = sn;
        this.dob = dob;
        this.add = add;
        this.tel = tel;
        this.email = email;
        this.ppNum = ppNum;
        this.paidPrice = paidPrice;
    }

    //method to extract customer's passport number
    public String getppNum() {
        return this.ppNum;
    }

    //method to extract customer's names(first name and surname)
    public String getName() {
        return this.fn + " " + this.sn;
    }

    //method to set aquisition price of tickets
    public void setpaidPrice(double pPrice) {
        this.paidPrice = pPrice;
    }

    //method to extract aquisition price of tickets
    public double getpaidPrice() {
        return this.paidPrice;
    }

}

