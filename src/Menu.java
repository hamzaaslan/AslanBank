import model.Account;
import model.Person;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


class Menu {
    private Scanner scan = new Scanner(System.in);
    private ArrayList<Person> personList = new ArrayList<>();

    Menu() {

        int task = -1;

        while (task != 7) {
            System.out.println("***MENU***");
            System.out.println("0: Kişi Oluştur");
            System.out.println("1: Hesap Aç");
            System.out.println("2: Hesap Bakiyesi");
            System.out.println("3: Para Yatır");
            System.out.println("4: Para Çek");
            System.out.println("5: Havale");
            System.out.println("6: Döviz İşlemleri");
            System.out.println("7: Çıkış");
            System.out.println("8: Kisi getir");
            task = scan.nextInt();

            double bakiye = 0;
            switch (task) {
                case 0:
                    System.out.println("0: Kişi Oluştur");
                    createPerson();
                    break;

                case 1:
                    System.out.println("***Hesap Tanımlama***");
                    createAccount();
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
                case 8:
                    System.out.println("Lütfen kisinin id sini giriniz!");
                    int personId = scan.nextInt();
                    Person myPerson = getPersonById(personId);
                    System.out.println(myPerson.getFirstName());
                    break;
                default:
                    System.out.println("Geçersiz İşlem!");
                    break;

            }
        }
    }

    Person getPersonById(int id){
        Person myPerson = null;
        System.out.println(id);
        for(Person person:personList) {
            if (person.getId() == id){
                myPerson = person;
            }
        }
        return myPerson;
    }

    public Date parseDateFromString(String myStringDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date= null;
        try {
            date = sdf.parse(myStringDate);
        } catch (ParseException e) {
            System.out.println("Lütfen dd/MM/yyyy formatta yeniden giriniz.");
          //  e.printStackTrace();
        }
        return date ;
    }

    private void createAccount() {

        System.out.println("Hesap Türü Giriniz: ");
        scan.nextLine();
        String type = scan.nextLine();

        System.out.println("Hesap Adı Giriniz: ");
        String name = scan.nextLine();

        Account account = new Account(type,name);
        System.out.println(account.getCreateDate());

    }

    private void createPerson() {

        System.out.println("TC Kimlik No Giriniz: ");
        scan.nextLine();
        String nationalId = scan.nextLine();

        System.out.println("İsim Giriniz: ");
        String firstName = scan.nextLine();

        System.out.println("Soyisim Giriniz: ");
        String lastName = scan.nextLine();

        String bDay;
        Date bDayinDateFormat;

        while (true){
            System.out.println("Doğum Tarihini Giriniz(dd/MM/yyyy): ");
            bDay = scan.nextLine();
            bDayinDateFormat = parseDateFromString(bDay);

            if (bDayinDateFormat != null )
                break;
        }

        System.out.println("TC Kimlik No: " + nationalId);
        System.out.println("Adı: " + firstName);
        System.out.println("Soyadı: " + lastName);
        System.out.println("Doğum Tarihi: " + bDay);

        Person person = new Person(nationalId, firstName, lastName, bDayinDateFormat);
        person.setId(personList.size()+1);
        System.out.println(person.getbDay());

        personList.add(person);

        System.out.println("Kayıtlı kişi sayısı: " + personList.size());
    }
}
