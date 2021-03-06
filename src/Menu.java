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
    private ArrayList<Account> accountList = new ArrayList<>();

    Menu() {
        loadTestDB();
        System.out.println("Sistemdeki kayıtlı kişi sayısı: " + personList.size());
        System.out.println("Sistemdeki kayıtlı hesap sayısı: " + accountList.size());
        int task = -1;
        while (task != 7) {
            System.out.println("------------------------------------");
            System.out.println("*** ANA MENU ***");
            System.out.println("------------------------------------");
            System.out.println("1: Kişi Oluştur");
            System.out.println("2: Hesap Aç");
            System.out.println("3: Döviz İşlemleri");
            System.out.println("4: Hesap Getir");
            System.out.println("5: Kişi Getir");
            System.out.println("6: Kişiyi İsim Girerek Getir");
            System.out.println("7: Çıkış");
            task = scan.nextInt();
            double bakiye = 0;
            switch (task) {
                case 1:
                    System.out.println("Kişi Oluştur");
                    createPerson();
                    break;
                case 2:
                    System.out.println("***Hesap Tanımlama***");
                    createAccount();
                    break;
                case 3:
                    exchangeOperation();
                    break;
                case 4:
                    accountOperation();
                    break;
                case 5:
                    System.out.println("Lütfen kisinin id sini giriniz!");
                    int personId = scan.nextInt();
                    Person myPerson = getPersonById(personId);
                    System.out.println(myPerson.getFirstName());
                    break;
                case 6:
                    nameOperation();
                    break;
                case 7:
                    System.out.println("Sistemden Çıkılıyor!");
                    break;
                default:
                    System.out.println("Geçersiz İşlem!");
                    break;
            }
        }
    }


    private void nameOperation() {
        scan.nextLine();
        System.out.println("Kişinin İsmini Yazınız!");
        String accountName = scan.nextLine();
        ArrayList<Account> personAccounts = getAccountsByUserName(accountName);
        System.out.println(personAccounts.size());

        for (Account myAccount : personAccounts) {

            System.out.println(myAccount.getType() + " " + myAccount.getName() + " " + myAccount.getBalance() + " TL'dir.");
        }
    }

    private Person getPersonById(int id) {
        Person myPerson = null;
        System.out.println(id);
        for (Person person : personList) {
            if (person.getId() == id) {
                myPerson = person;
                break;
            }
        }
        return myPerson;
    }

    private Account getAccountById(int id) {
        Account myAccount = null;
        System.out.println(id);
        for (Account account : accountList) {
            if (account.getId() == id) {
                myAccount = account;
                break;
            }
        }
        return myAccount;
    }

    private ArrayList<Account> getAccountsByUserName(String name) {
        ArrayList<Account> myAccounts = new ArrayList<>();
        for (Account account : accountList) {
            if (account.getName().equals(name)) {
                myAccounts.add(account);
            }
        }
        return myAccounts;
    }

    private Date parseDateFromString(String myStringDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = sdf.parse(myStringDate);
        } catch (ParseException e) {
            System.out.print("Lütfen dd/MM/yyyy formatta yeniden giriniz.");
            //  e.printStackTrace();
        }
        return date;
    }

    private void createAccount() {

        System.out.print("Hesap Türü Giriniz: ");
        scan.nextLine();
        String type = scan.nextLine();
        System.out.print("Hesap Adı Giriniz: ");
        String name = scan.nextLine();
        Account account = new Account(type, name);
        account.setId(accountList.size() + 1);
        accountList.add(account);
        System.out.println("Kayıtlı hesap sayısı: " + accountList.size());
    }

    private void createPerson() {

        System.out.print("TC Kimlik No Giriniz: ");
        scan.nextLine();
        String nationalId = scan.nextLine();
        System.out.print("İsim Giriniz: ");
        String firstName = scan.nextLine();
        System.out.print("Soyisim Giriniz: ");
        String lastName = scan.nextLine();
        String bDay;
        Date bDayinDateFormat;

        while (true) {
            System.out.print("Doğum Tarihini Giriniz(dd/MM/yyyy): ");
            bDay = scan.nextLine();
            bDayinDateFormat = parseDateFromString(bDay);
            if (bDayinDateFormat != null)
                break;
        }
        System.out.println("------------------------------------");
        System.out.println("TC Kimlik No: " + nationalId);
        System.out.println("Adı: " + firstName);
        System.out.println("Soyadı: " + lastName);
        System.out.println("Doğum Tarihi: " + bDay);
        Person person = new Person(nationalId, firstName, lastName, bDayinDateFormat);
        person.setId(personList.size() + 1);
        System.out.println(person.getbDay());
        personList.add(person);
        System.out.println("Kayıtlı kişi sayısı: " + personList.size());
    }

    private void exchangeOperation() {
        Scanner oku = new Scanner(System.in);
        double dolars, dolara, sonuc, para;
        dolars = 5 + (Math.random());
        dolara = 4 + (Math.random());
        int a;
        System.out.println("Kur Alış: " + dolara + " Kur Satış: " + dolars);
        System.out.print("Döviz almak için 1, satmak için 2 yazınız! ");
        a = oku.nextInt();
        if (a == 1) {
            System.out.print("Ne kadar döviz alacaksınız?");
            para = oku.nextDouble();
            sonuc = para * dolara;
            System.out.println(para + " USD için " + sonuc + " TL gereklidir..");
            System.out.printf(para + " USD için %.2f", sonuc);
            System.out.print(" TL gereklidir.\n");
        } else if (a == 2) {
            System.out.print("Ne Kadar Döviz Satacaksınız?");
            para = oku.nextDouble();
            sonuc = para * dolars;
            System.out.println(para + " Dolar " + sonuc + " TL yapmaktadır.");
            System.out.printf(para + " Dolar %.2f", sonuc);
            System.out.print(" TL yapmaktadır.\n");
        } else
            System.out.print(" Yanlış işlem seçtiniz!");

    }

    private void loadTestDB() {
        Person person = new Person("1234", "Elif", "Aslan", parseDateFromString("12/12/1900"));
        person.setId(personList.size() + 1);
        personList.add(person);
        Person person2 = new Person("12345", "Yusuf", "Aslan", parseDateFromString("12/12/1901"));
        person2.setId(personList.size() + 1);
        personList.add(person2);
        Person person3 = new Person("123456", "Betül", "Aslan", parseDateFromString("12/12/1902"));
        person3.setId(personList.size() + 1);
        personList.add(person3);
        Person person4 = new Person("1234567", "Hamza", "Aslan", parseDateFromString("12/12/1903"));
        person4.setId(personList.size() + 1);
        personList.add(person4);
        Person person5 = new Person("12345678", "Zeynep", "Aslan", parseDateFromString("12/12/1904"));
        person5.setId(personList.size() + 1);
        personList.add(person5);
        Person person6 = new Person("123456789", "Asuman", "Aslan", parseDateFromString("12/12/1905"));
        person6.setId(personList.size() + 1);
        personList.add(person6);

        Account account = new Account("123456789", "Asuman");
        account.setId(accountList.size() + 1);
        accountList.add(account);
        Account account2 = new Account("12345", "Yusuf");
        account2.setId(accountList.size() + 1);
        accountList.add(account2);
        Account account3 = new Account("12345678", "Zeynep");
        account3.setId(accountList.size() + 1);
        accountList.add(account3);
        Account account4 = new Account("222", "Asuman");
        account4.setId(accountList.size() + 1);
        accountList.add(account4);
        Account account5 = new Account("111", "Yusuf");
        account5.setId(accountList.size() + 1);
        accountList.add(account5);
    }

    private void accountOperation() {
        int task;
        int miktar = 0;
        System.out.println("Hesap Getir");
        int accountId = scan.nextInt();
        Account myAccount = getAccountById(accountId);
        System.out.println(myAccount.getType() + " " + myAccount.getName() + " " + myAccount.getBalance() + " TL'dir.");
        int bakiye = myAccount.getBalance();
        task = -1;
        while (task != 5) {
            System.out.println("------------------------------------");
            System.out.println("Bir işlem seçiniz: ");
            System.out.println("1: Hesap Bakiyesi");
            System.out.println("2: Para Çek");
            System.out.println("3: Para Yatır");
            System.out.println("4: Havale");
            System.out.println("5: Ana Menüye Geri Dön");
            task = scan.nextInt();
            switch (task) {
                case 1:
                    System.out.print("Bakiyeniz:" + bakiye + " TL'dir.");
                    break;
                case 2:
                    System.out.println("Ne Kadar Çekeceksiniz?");
                    miktar = scan.nextInt();

                    if (bakiye < miktar) {
                        System.out.println("Bakiyenizden Fazla TL Çekemezsiniz!");
                        break;
                    }
                    bakiye -= miktar;
                    System.out.println("Bakiyeniz: " + bakiye + " TL'dir.");
                    break;
                case 3:
                    System.out.println("Ne Kadar Yatıracaksınız?");
                    miktar = scan.nextInt();
                    bakiye += miktar;
                    System.out.println("Bakiyeniz: " + bakiye + " TL'dir.");
                    break;
                case 4:
                    System.out.println("Hangi hesaba havale yapacaksınız?");
                    int targetAccountId = scan.nextInt();
                    Account targetAccount = getAccountById(targetAccountId);
                    System.out.println("Ne kadar havale yapacaksınız?");
                    int havaleMiktar = scan.nextInt();
                    if (bakiye < havaleMiktar) {
                        System.out.println("Bakiyenizden Fazla Havale Yapamazsınız!");
                        break;
                    }
                    bakiye -= havaleMiktar;
                    System.out.println("Bakiyeniz: " + bakiye + " TL'dir.");
                    int targetIndex = accountList.indexOf(targetAccount);
                    targetAccount.setBalance(targetAccount.getBalance() + havaleMiktar);
                    accountList.set(targetIndex, targetAccount);
                    break;
                case 5:
                    System.out.println("Ana Menüye geri dönülüyor!");
                    break;
                default:
                    System.out.println("Geçersiz İşlem!");
                    break;
            }
            int index = accountList.indexOf(myAccount);
            myAccount.setBalance(bakiye);
            accountList.set(index, myAccount);
        }
    }
}