package ra.dev;

import java.util.Scanner;

public class Catalog {
    private int catalogId;
    private String catalogName;
    private int priority;
    private Boolean catalogStatus;

    public Catalog(){

    }

    public Catalog(int catalogId, String catalogName, int priority, Boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priority = priority;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Boolean getCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(Boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputData(Scanner sc){
        System.out.println("Nhập mã danh mục sản phẩm: ");
        this.catalogId = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tên danh mục sản phẩm: ");
        this.catalogName = sc.nextLine();
        System.out.println("Nhập độ ưu tiên: ");
        this.priority = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập trạng thái: ");
        this.catalogStatus = Boolean.parseBoolean(sc.nextLine());
    }

    public void displayData(){
        System.out.printf("Ma DM: %d - Ten DM: %s - Do UT: %d - Trang thai: %b\n",this.catalogId,
                this.catalogName,this.priority,this.catalogStatus);
    }
}
