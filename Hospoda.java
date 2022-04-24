/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospoda;
import java.util.ArrayList;

/**
 *
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
            System.out.println(c.nameOfCustomer + " you are too young for: " + d.nameOfDrink + "!");
         }
        if(d.amountOfDrink !=0){
        System.out.println("There is : " + d.amountOfDrink + " " + d.nameOfDrink + " left." );}
        
        System.out.println("You are at index : " + (counterOfIndex - 1));
    }
      
     //This method prints importatnt info about Hospoda
      public static void closePub(Hospoda h,  Drink d1, Drink d2){       
       System.out.println("\nBalance of pub: " + h.balanceOfHospoda + "$.");
       System.out.println(d1.nameOfDrink + " : " + d1.amountOfDrink);
       System.out.println(d2.nameOfDrink + " : " + d2.amountOfDrink);
      }
      
     //This method prints important info about Customer  
      public static void closeCustomerAcc(Customer c){
      System.out.println(c.nameOfCustomer + "´s balance : " + c.balanceOfCustomer + "$.");
      }
    
      //Method searching for ocurance of Customer in ArrayList and saving it´s indexes as Arraylist<Integer>. Not functioning since its hard to implement searching from exact index.
     /* public static ArrayList<Integer> AnalyseArray(ArrayList<String> a, Customer c) {          
        int startSearch = 0;
        ArrayList<Integer> indexOfOcuranceList = new ArrayList<Integer>();
        
        int start = a.indexOf(c.nameOfCustomer, startSearch);
        int indexOfCustomer = -1;
        
        while (start != -1){
        if (start != -1, ){
        
        }
        }
                
        indexOfOcuranceList.add(a.indexOf(c.nameOfCustomer));
        //indexOfOcuranceList.add(a.indexOf((searchStart, c.nameOfCustomer)));
        return indexOfOcuranceList;
        }
      */
      // Prints out Arraylists storing info about transaction
      public static void printArraylists(){
      System.out.println(customerNamesList);
      System.out.println(soldCocktailNamesList);
      System.out.println(soldCocktailPricesList);
      }
      
      // MAIN METHOD
    public static void main(String[] args) {
    //Creating arrayList of sold products.
    //ArrayList<String> ucet = new ArrayList<>();
    //ucet.add("dan");
    //System.out.println("Array list on index 0 is: " + ucet);
    //Creating Objects
        Hospoda kobyla = new Hospoda("Kobyla", 10000.0);
        //System.out.println(kobyla.nameOfHospoda + " was created.");       
        Customer dan = new Customer("Daniel", 27, 100.0);
        //System.out.println(dan.nameOfCustomer + " was created.");        
        Customer evelina = new Customer("Evelína", 1, 300.0);
        //System.out.println(evelina.nameOfCustomer + " was created.");        
        Drink beer = new Drink("Pivo", true, 10, 10.0);
        //System.out.println(beer.nameOfDrink + " was created.");      
        Drink water = new Drink("Voda", false, 5, 5.0);
        //System.out.println(water.nameOfDrink + " was created.");
        
    // loop
       for(int i =1; i<11; i++){
            kobyla.sell(dan, beer);
            //kobyla.sell(evelina, beer);
            kobyla.sell(evelina, water);
            //kobyla.sell(dan, water);
       } 
       
       kobyla.sell(dan, beer);
       kobyla.sell(evelina, water);
       
       closePub(kobyla, water, beer);
       
       printArraylists();
       
       closeCustomerAcc(dan);
       
       dan.bill.add("Pivo");

      // System.out.println(AnalyseArray(customerNamesList, dan));
    }

}