package ra.dev;

import java.util.Calendar;
import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private String title;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private String descriptions;
    private Boolean productStatus;
    private Catalog catalog;

    public Product(){

    }

    public Product(String productId, String productName, String title,
                   float importPrice, float exportPrice, int quantity,
                   String descriptions, Boolean productStatus,
                   Catalog catalog) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.productStatus = productStatus;
        this.catalog = catalog;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Boolean getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Boolean productStatus) {
        this.productStatus = productStatus;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public void inputData(Scanner sc, Catalog[] arrCatalog, int indexMax){
        System.out.println("Nh???p ID s???n ph???m: ");
        this.productId = sc.nextLine();
        System.out.println("Nh???p t??n s???n ph???m: ");
        this.productName = sc.nextLine();
        System.out.println("Nh???p ti??u ????? s???n ph???m: ");
        this.title = sc.nextLine();
        System.out.println("Gi?? nh???p kh???u: ");
        this.importPrice = Float.parseFloat(sc.nextLine());
        System.out.println("H??ng t???n: ");
        this.quantity = Integer.parseInt(sc.nextLine());
        System.out.println("M?? t??? s???n ph???m: ");
        this.descriptions =sc.nextLine();
        System.out.println("T??nh tr???ng s???n ph???m: ");
        this.productStatus = Boolean.parseBoolean(sc.nextLine());
        System.out.println("S???n ph???m thu???c danh m???c: ");
        for (int i = 0; i < indexMax ; i++) {
            System.out.printf("%d.%s\n",(i+1),arrCatalog[i].getCatalogName());
        }
        System.out.printf("Lua ch???n c???a b???n: ");
        int indexChoice = Integer.parseInt(sc.nextLine());
        //Set ?????i t?????ng danh m???c cho s???n ph???m
        this.catalog = arrCatalog[indexChoice-1];
    }

    public void displayData(){
        System.out.printf("Ma SP: %s - Ten SP: %s - Tieu de: %s\n", this.productId, this.productName, this.title);
        System.out.printf("Gia nhap: %f - gia xuat: %f - So luong: %d\n", this.importPrice, this.exportPrice, this.quantity);
        String trangThai = "";
        if (this.productStatus) {
            trangThai = "Con ban";
        } else {
            trangThai = "Khong ban";
        }
        System.out.printf("Trang thai: %s - Danh muc: %s\n",trangThai,this.catalog.getCatalogName());

    }

    public void calExportPrice(){
        this.exportPrice = this.importPrice*1.2F;
    }



}
