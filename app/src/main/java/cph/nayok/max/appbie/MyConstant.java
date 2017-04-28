package cph.nayok.max.appbie;

/**
 * Created by PCYOU on 4/28/2017.
 */

public class MyConstant {

    private String urlGetProductWhereQR = "http://swiftcodingthai.com/cph/getProductWhereQRSupermax.php";

    private String[] columnProduct = new String[]{"id", "Name", "QR_code", "id_Receive", "Description", "Date_Receive"};

    private String urlGetuserWhereID = "http://swiftcodingthai.com/cph/getUserWhereID.php";

    public String getUrlGetuserWhereID() {
        return urlGetuserWhereID;
    }

    public String[] getColumnProduct() {
        return columnProduct;
    }

    public String getUrlGetProductWhereQR() {



        return urlGetProductWhereQR;
    }
}//Main Class
