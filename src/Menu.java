import model.Person;

import java.util.Scanner;


class Menu {
    private Scanner scan = new Scanner(System.in);
    private int islem = -1;

    Menu() {

        while (islem != 7) {
            System.out.println("***MENU***");
            System.out.println("1: Hesap Aç");
            System.out.println("2: Hesap Bakiyesi");
            System.out.println("3: Para Yatır");
            System.out.println("4: Para Çek");
            System.out.println("5: Havale");
            System.out.println("6: Döviz İşlemleri");
            System.out.println("7: Çıkış");
            islem = scan.nextInt();

            double bakiye = 0;
            switch (islem) {
                case 1:
                    System.out.println("***Hesap Tanımlama***!");
                    createPerson();
                    break;

                case 2:
                    System.out.println("Bakiyeniz:" + bakiye + "TL'dir.");
                    break;
                case 3:
                    System.out.println("Ne Kadar Yatıracaksınız?");
                    int miktar = scan.nextInt();

                    bakiye += miktar;
                    System.out.println("Bakiyeniz: " + bakiye + "TL'dir.");
                    break;

                case 4:
                    System.out.println("Ne Kadar Çekeceksiniz?");
                    miktar = scan.nextInt();

                    if (bakiye < miktar) {
                        System.out.println("Bakiyenizden Fazla TL Çekemezsiniz!");
                        break;
                    }
                    bakiye -= miktar;
                    System.out.println("Bakiyeniz: " + bakiye + "TL'dir.");
                    break;
                case 5:

                case 6:

                case 7:
                    System.out.println("Sistemden Çıkılıyor!");

                    break;
                default:
                    System.out.println("Geçersiz İşlem!");
                    break;

            }
        }
    }

    private void createPerson() {


        System.out.println("TC Kimlik No Giriniz: ");
        scan.nextLine();
        String nationalId =scan.nextLine();

        System.out.println("İsim Giriniz: ");
        String firstName=scan.nextLine();

        System.out.println("Soyisim Giriniz: ");
        String lastName =scan.nextLine();

        System.out.println("Doğum Tarihini Giriniz: ");
        String bDay =scan.nextLine();


        System.out.println("TC Kimlik No: " + nationalId);
        System.out.println("Adı: " + firstName);
        System.out.println("Soyadı: " + lastName);
        System.out.println("Doğum Tarihi: " + bDay);

        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setNationalId(nationalId);
        person.setbDay(bDay);


    }
}












