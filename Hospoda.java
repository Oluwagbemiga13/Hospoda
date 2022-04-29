/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospoda;
import java.util.ArrayList;

/**
 * This program imitates pub. It creates customers and drinks. 
 * It sells drinks to customer and count balances of pub and customers. 
 * It also  keeps track of drinks avalible
 * It is able to keep track of orders and prints bill.
 * It needs to be redone so you will have more objects like "reciept, ledger, walet ect. -> First you need to learn inheritance and polymorphism.
 * @author Daniel
 */
public class Hospoda {

    /**
     * @param args the command line arguments
     */
    
    String nameOfHospoda;
    double balanceOfHospoda;
    static ArrayList<String> customerNamesList = new ArrayList<String>();
    static ArrayList<String> soldCocktailNamesList = new ArrayList<String>();
    static ArrayList<Double> soldCocktailPricesList = new ArrayList<Double>();
    int counterOfIndex = 0;
    public static ArrayList<Integer> indexList = new ArrayList<>();
    public static ArrayList <String> nameList = new ArrayList<>();
    
    // Hospoda Constructor
    public Hospoda(String name, double balance){
    nameOfHospoda = name;
    balanceOfHospoda = balance;
    }
    
    /* Method sell takes object Customer and object Drink and decide if it´s legal to sell it.
    If it´s legal than sell Drink and lower Drink.amountOfCocktail by 1. 
    Otherwise print -> Customer.nameOfCustomer you are too young for: Drink.nameOfDrink!
    */
      public void sell(Customer c, Drink d){
        if (d.amountOfDrink == 0){
            System.out.println("\n" + "There is no more " + d.nameOfDrink + " left.");
        }   
        else if(c.balanceOfCustomer < d.priceOfCocktail){
            System.out.println("\n" +  c.nameOfCustomer + " ,you are " + (d.priceOfCocktail - c.balanceOfCustomer) + "$ short!");
        }
        else if(!d.isAlcoholic) {
            d.amountOfDrink --;
            balanceOfHospoda = balanceOfHospoda + d.priceOfCocktail;
            c.balanceOfCustomer = c.balanceOfCustomer - d.priceOfCocktail;
            customerNamesList.add(c.nameOfCustomer );
            soldCocktailNamesList.add(d.nameOfDrink);
            soldCocktailPricesList.add(counterOfIndex, d.priceOfCocktail);
            counterOfIndex ++;
            System.out.println("\n" + d.nameOfDrink + " was sold to " + c.nameOfCustomer + "." );

            }
        else if(d.isAlcoholic && c.ageOfCustomer >=18){
            d.amountOfDrink --;
            balanceOfHospoda = balanceOfHospoda + d.priceOfCocktail;
            c.balanceOfCustomer = c.balanceOfCustomer - d.priceOfCocktail;
            customerNamesList.add(c.nameOfCustomer );
            soldCocktailNamesList.add(d.nameOfDrink);
            soldCocktailPricesList.add(counterOfIndex, d.priceOfCocktail);
            counterOfIndex ++;
            System.out.println("\n" + d.nameOfDrink + " was sold to " + c.nameOfCustomer + "." );
        } 
        
        else {
            System.out.println("\n" + c.nameOfCustomer + " you are too young for: " + d.nameOfDrink + "!");
         }
        if(d.amountOfDrink !=0){
        System.out.println("There is : " + d.amountOfDrink + " " + d.nameOfDrink + " left." );}
        
        System.out.println("You are at index : " + (counterOfIndex - 1));
    }
      
     //This method prints importatnt info about Hospoda
      public static void closePub(Hospoda h,  Drink d1, Drink d2){
       System.out.println("\nMETODA closePub");
       System.out.println("Balance of pub: " + h.balanceOfHospoda + "$.");
       System.out.println(d1.nameOfDrink + " : " + d1.amountOfDrink);
       System.out.println(d2.nameOfDrink + " : " + d2.amountOfDrink);
      }
      
     //This method prints important info about Customer  
      public static void closeCustomerAcc(Customer c){
        System.out.println("\nMETODA closeCustomerAcc");
        System.out.println(c.nameOfCustomer + "´s balance : " + c.balanceOfCustomer + "$.");
      
      }
    
      // Prints out Arraylists storing info about transaction
      public static void printArraylists(){
      System.out.println("\nMETODA printArraylists ");
      System.out.println("There were those customers: " + customerNamesList);
      System.out.println("We sold those drinks: " + soldCocktailNamesList);
      System.out.println("We charged customers those amounts of money: " + soldCocktailPricesList);
      }
      
    // method searching for indexes in a where is Customer o located in ArrayList a -> RETURN ArrayList<Integer>
    public static ArrayList<Integer> searchCustomer (Customer o, ArrayList<String> a){
        
        ArrayList<Integer> tempA = new ArrayList<>();
        System.out.println("\nMETODA searchCustomer");

        if(a.indexOf(o.nameOfCustomer) != -1){

            for(int i = 0; i < a.size(); i++){
                //System.out.println("Index of " + o.nameOfArrayListFinder + " is "  + a.indexOf("Dan"));
                if(o.nameOfCustomer.equals(a.get(i))){
                    //System.out.println(a.get(i));
                    tempA.add(i);
                   
                    //indexList.add(tempA.get(i));
                    //indexList.add(i);
                }  
            }
        }
        else{
        System.out.println("There is no " + o.nameOfCustomer + ".");
        }
        for (int i = 0 ; i <= tempA.size() -1 ;i++){
            indexList.add(tempA.get(i)) ;
        }
        //System.out.println("Size of tempA for " + o.nameOfCustomer + " is : " + tempA.size());
        return tempA;
    }
    
    // method searching for indexes in a where is Drink located in ArrayList a -> RETURN ArrayList<Integer>
    // It seems to be useless now. method countDrinks works better.
    public static ArrayList<Integer> searchDrink (Drink o, ArrayList<String> a){
        
        ArrayList<Integer> tempA = new ArrayList<>();

        if(a.indexOf(o.nameOfDrink) != -1){

            for(int i = 0; i < a.size(); i++){
                //System.out.println("Index of " + o.nameOfArrayListFinder + " is "  + a.indexOf("Dan"));
                if(o.nameOfDrink.equals(a.get(i))){
                    tempA.add(i);
                }  
            }
        }
        else{
        System.out.println("There is no " + o.nameOfDrink + ".");
        }
        for (int i = 0 ; i <= tempA.size() -1 ;i++){
            indexList.add(tempA.get(i)) ;
        }
        System.out.println("Size of tempA for " + o.nameOfDrink + " is : " + tempA.size());
        return tempA;
    }
    
    // Printing out names stored in ArrayList nameList.
    public static ArrayList<String> printNames(ArrayList<Integer> a){
        ArrayList<String> tempB = new ArrayList<>();
        
        if(a.size() > 0){
            //System.out.println("Printing out all ocurance : ");
            for(int i = 0; i < a.size(); i++){
                //System.out.print(customerNamesList.get(a.get(i)) + " ");
                //System.out.println("i = " + i);
                
        }
        System.out.println(" \n");
        }
        else{
            System.out.println("There are no drinks!");}
        return tempB;
    }
    
    //Method printing out sold drinks in ArrayList soldCocktailNamesList
    public static ArrayList<String> countDrinks(ArrayList<Integer> a){
        ArrayList<String> tempC = new ArrayList<>();
        //System.out.println("METODA countDrinks ");
        //System.out.println("indexList<> :" + indexList);
        if(a.size() > 0){
            //System.out.println("Printing out all ocurance : ");
            for(int i = 0; i < a.size(); i++){
                // Here you will change it to store it as ArrayList
                tempC.add(soldCocktailNamesList.get(a.get(i)));
                //System.out.print(soldCocktailNamesList.get(a.get(i)) + " ");
                //System.out.println("i = " + i);
                
        }
        }
        else{
            System.out.println("There are none names");}
        //System.out.println(tempC);
        return tempC;
    }
    
    //Method printing out  sold drinks in ArrayList soldCocktailPricesList
    public static ArrayList<Double> countPrices(ArrayList<Integer> a){
        ArrayList<Double> tempD = new ArrayList<>();
        System.out.println("\nMETODA countPrices ");
        //System.out.println("indexList<> :" + indexList);
        if(a.size() > 0){
            //System.out.println("Printing out all ocurance : ");
            //System.out.println("It´s broken somewhere HERE.");
            for(int i = 0; i < a.size(); i++){
                // Here you will change it to store it as ArrayList
                tempD.add(soldCocktailPricesList.get(a.get(i)));
                //System.out.print(soldCocktailNamesList.get(a.get(i)) + " ");
                //System.out.println("i = " + i);               
        }
        }
        else{
            System.out.println("There are none prices");}
        
        //System.out.println(tempD);
        return tempD;
    }
    
    //Method counting total bill 
    public static double totalBill(Customer c, ArrayList<Integer> a){
        double total = 0.0;
        //double predchoziSoucet = 0.0;
        double nasledujiciCislo;
        
        if(a.size() > 0){
            //System.out.println("Printing out all ocurance : ");
            for(int i = 0; i < a.size(); i++){
                // Here you will change it to store it as ArrayList
                nasledujiciCislo = soldCocktailPricesList.get(a.get(i));
                total = total + nasledujiciCislo;
                //tempD.add(soldCocktailPricesList.get(a.get(i)));
                //System.out.print(soldCocktailNamesList.get(a.get(i)) + " ");
                //System.out.println("i = " + i);
                
        }
        }
    return total;
    }
    
    //Method printing everything out as reciept 
    public static void printBill(Customer c, ArrayList<Integer> a){
        System.out.println("\nMETODA printBill");
        if(indexList.size()!=-1){
            System.out.println("\n" + c.nameOfCustomer + "´s bill.");
            for (int i = 0; i < indexList.size(); i++){
                System.out.println(soldCocktailNamesList.get(a.get(i)) + " " + soldCocktailPricesList.get(a.get(i)) + "$");
            }
            System.out.println("Your total is " + totalBill(c, a));
        }
        else {
            System.out.println("There is nothing on your bill!");
        }
        closeCustomerAcc(c);
        a.clear();
    }
    
    //Method puting it together - NEFUNGUJE
    public static void printReciept(Customer c, ArrayList<Integer> a, ArrayList<String> b){
        System.out.println("\nMETODA printReciept");
        searchCustomer(c, customerNamesList);
        printNames(indexList);
        countDrinks(indexList);
        countPrices(indexList);
    }

      // MAIN METHOD
    public static void main(String[] args) {

    //Creating Objects
        Hospoda kobyla = new Hospoda("Kobyla", 10000.0);
        //System.out.println(kobyla.nameOfHospoda + " was created.");       
        Customer dan = new Customer("Daniel", 27, 100.0);
        //System.out.println(dan.nameOfCustomer + " was created.");        
        Customer evelina = new Customer("Evelína", 1, 300.0);
        //System.out.println(evelina.nameOfCustomer + " was created.");
        Customer valerie = new Customer("Valerie", 0, 500.0);
        //System.out.println(evelina.nameOfCustomer + " was created.");         
        Drink beer = new Drink("Pivo", true, 10, 10.0);
        //System.out.println(beer.nameOfDrink + " was created.");      
        Drink water = new Drink("Voda", false, 5, 5.0);
        //System.out.println(water.nameOfDrink + " was created.");
        Drink milk = new Drink("Mlíčko", false, 5, 5.0);
        //System.out.println(water.nameOfDrink + " was created.");
        
    // loop for testing
       for(int i =0; i<3; i++){
            kobyla.sell(dan, beer);
            kobyla.sell(evelina, beer);
            kobyla.sell(evelina, water);
            //kobyla.sell(dan, water);
       } 
       
       closePub(kobyla, water, beer);
       
       printArraylists();
       
       closeCustomerAcc(dan);
       closeCustomerAcc(evelina);
       ///
      /*
      searchCustomer(dan, customerNamesList);
      printNames(indexList);
      //searchDrink(beer, soldCocktailNamesList);
      countDrinks(indexList);
      countPrices(indexList);*/
      
      printReciept(dan, indexList, customerNamesList);
      totalBill(dan, indexList);
      System.out.println(totalBill(dan, indexList));
      printBill(dan,indexList);
      
      
      printReciept(evelina, indexList, customerNamesList);
      printBill(evelina,indexList);
      
      for(int i = 1; i < 5; i++){
        kobyla.sell(valerie, milk);
      }
      printReciept(valerie, indexList, customerNamesList);
      printBill(valerie,indexList);
      
    }

}