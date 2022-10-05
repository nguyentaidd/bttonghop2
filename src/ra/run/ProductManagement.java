package ra.run;

import ra.dev.Product;

import ra.dev.Catalog;

import javax.jws.soap.SOAPBinding;
import java.util.Scanner;

public class ProductManagement {
    static Product[] arrProduct = new Product[1000];
    static Catalog[] arrCatalog = new Catalog[50];
    static int indexProduct = 0;
    static int indexCatalog = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("****QUAN LY CUA HANG****");
            System.out.println("1. Quan ly danh muc");
            System.out.println("2. Quan ly san pham");
            System.out.println("3. Thoat");
            System.out.print("Su lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    ProductManagement.menuCatalog(sc);
                    break;
                case 2:
                    ProductManagement.menuProduct(sc);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Vui long chon tu 1-3");
            }
        } while (true);

    }
    public static void menuCatalog(Scanner sc){
        boolean exitMenuCatalog = true;
        do {
            System.out.println("*****QUAN LY DANH MUC*****");
            System.out.println("1. Nhap thong tin danh muc");
            System.out.println("2. Hien thi thong tin danh muc");
            System.out.println("3. Cap nhat thong tin danh muc");
            System.out.println("4. Thoat");
            System.out.print("Su lua chon của bạn: ");
            int choiceCatalog = Integer.parseInt(sc.nextLine());
            switch (choiceCatalog){
                case 1:
                    ProductManagement.inputListCatalog(sc);
                    break;
                case 2:
                    ProductManagement.displayListCatalog();
                    break;
                case 3:
                    ProductManagement.updateCatalog(sc);
                case 4:
                    exitMenuCatalog = false;
                    break;
                default:
                    System.err.println("Vui long chon tu 1-4");

            }
        } while (exitMenuCatalog);
    }

    public static void menuProduct(Scanner sc){
        Boolean exitMenuProduct = true;
        do {
            System.out.println("*****QUAN LY SAN PHAM*****");
            System.out.println("1. Nhập thông tin sản phẩm");
            System.out.println("2. Nhập giá bán sản phẩm");
            System.out.println("3. Hiển thị thông tin sản phẩm");
            System.out.println("4. Sắp xếp sản phẩm theo giá bán tăng dần");
            System.out.println("5. Tìm sản phẩm theo tên");
            System.out.println("6. Thống kê số lượng và in thông tin sp hết hàng");
            System.out.println("7. Cập nhật trạng thái của sản phẩm theo mã");
            System.out.println("8. Bán hàng");
            System.out.println("9. Nhập hàng");
            System.out.println("10. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choiceProduct = Integer.parseInt(sc.nextLine());
            switch (choiceProduct){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    exitMenuProduct = false;
                    break;
                default:
                    System.err.println("Vui lòng nhập từ 1-10");
            }
        } while (exitMenuProduct);
    }

    public static void inputListCatalog(Scanner sc){
        System.out.println("Đánh số danh mục cần nhập thông tin: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            arrCatalog[indexCatalog]= new Catalog();
            arrCatalog[indexCatalog].inputData(sc);
            indexCatalog++;
        }
    }

    public static void displayListCatalog(){
        //Hiển thị danh mục theo độ ưu tiên
        //1.Sắp xếp danh mục theo độ ưu tiên tăng dần
        for (int i = 0; i < indexCatalog-1; i++) {
            for (int j = i+1; j <indexCatalog ; j++) {
                if (arrCatalog[i].getPriority()>arrCatalog[j].getPriority()){
                    Catalog temp = arrCatalog[i];
                    arrCatalog[i] = arrCatalog[j];
                    arrCatalog[j] = temp;
                }
            }
        }
        //2.Hiển thị danh mục
        for (int i = 0; i < indexCatalog; i++) {
            arrCatalog[i].displayData();
        }
    }

    public static void updateCatalog(Scanner sc){
        System.out.println("Nhấp vào mã danh mục cần cập nhật thông tin: ");
        int catalogIdUpdate = Integer.parseInt(sc.nextLine());
        //1. Tìm trong danh sách danh mục cần cập nhật
        int indexCatalogUpdate = -1;
        for (int i = 0; i < indexCatalog; i++) {
            if (arrCatalog[i].getCatalogId()==catalogIdUpdate)
                indexCatalogUpdate = i;
            break;
        }
        if (indexCatalogUpdate!=-1){
            //2. Cập nhật danh mục theo mã
            System.out.println("Nhập vào tên danh mục cần cập nhật: ");
            String catalogName = sc.nextLine();
            if (catalogName!=""&&catalogName.length()!=0){
                arrCatalog[indexCatalogUpdate].setCatalogName(catalogName);
            }
            System.out.println("Nhập độ ưu tiên danh mục: ");
            String priority = sc.nextLine();
            if(priority!=""&&priority.length()!=0){
                arrCatalog[indexCatalogUpdate].setPriority(Integer.parseInt(priority));
            }
            System.out.println("Nhập vào trạng thái danh mục: ");
            String status = sc.nextLine();
            if (status!=""&&status.length()!=0){
                arrCatalog[indexCatalogUpdate].setCatalogStatus(Boolean.parseBoolean(status));
            }
        } else
            System.out.println("Mã danh mục không tồn tại!");
    }

    public static void inputListProduct(Scanner sc){
        System.out.println("Nhập số sản phẩm cần nhập thông tin: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin san phẩm thứ: "+(i+1));
            arrProduct[indexProduct] = new Product();
            arrProduct[indexProduct].inputData();
            indexProduct++;
        }
    }

}
