/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospoda;

/**
 *
 * @author Daniel
 */
public class Drink {
    String nameOfDrink;
    boolean isAlcoholic;
    int amountOfDrink;
    double priceOfCocktail;

    public Drink(String name, boolean ContainsAlcohol, int amount, double price){
    nameOfDrink = name;
    isAlcoholic = ContainsAlcohol;
    amountOfDrink = amount;
    priceOfCocktail = price;
    }
}
