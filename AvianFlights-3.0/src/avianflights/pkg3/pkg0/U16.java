package avianflights.pkg3.pkg0;

public class U16 extends Customer {

    Customer parent;

    public U16(String fn, String sn, String dob, String add, String tel, String email, String ppNum, Customer cust) {
        super(fn, sn, dob, add, tel, email, ppNum);
        parent = cust;
    }
}
