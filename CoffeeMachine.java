package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int coffee = 120;
    static int cups = 9;
    static int money = 550;
    
    public enum menuChoice {
        MAIN_MENU("main menu"),
        BYING_MENU("to buy"),
        FILLING_MENU("to fill");     
        
        private final String condition;
        
        menuChoice (String cond) {
            this.condition = cond;
        }   
        
        public String getChoice() {
            return condition;
        }
    }
    
    public static void mainMenu() {
       CoffeeMachine cfmachine = new CoffeeMachine();
       Scanner sc = new Scanner(System.in);
       
       boolean working = true;
       while (working) {
           System.out.println("Write action (buy, fill, take, remaining, exit):");
           String answer = sc.next();
           switch (answer) {
               case "buy":
                   cfmachine.buy();
                   break;
               case "fill":
                   cfmachine.fill();
                   break;
               case "take":
                   cfmachine.take();
                   break;
               case "remaining":
                   cfmachine.info();
                   break;
               case "exit":
                   working = false;
                   break;
           }
       } 
    }

    public void info () {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffee + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
        System.out.println();
        }

    public void buy () {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        Scanner sc = new Scanner(System.in);
        String answer = sc.next();
        if (water >= 200 && milk >= 75 && coffee >= 12 && cups >= 1) {
            switch (answer) {
                case "1":
                    water -= 250;
                    coffee -= 16;
                    cups -= 1;
                    money += 4;
                    break;
                case "2":
                    water -= 350;
                    milk -= 75;
                    coffee -= 20;
                    cups -= 1;
                    money += 7;
                    break;
                case "3":
                    water -= 200;
                    milk -= 100;
                    coffee -= 12;
                    cups -= 1;
                    money += 6;
                    break;
                case "back":
                    break;
                default:
            }
            System.out.println("I have enough resources, making you a coffee!");
        } else if (water < 200) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < 75) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffee < 12) {
            System.out.println("Sorry, not enough coffee!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
        }
        System.out.println();
    }

    public void fill () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffee += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += sc.nextInt();
        System.out.println();
    }

    public void take () {
        System.out.println("I gave you $" + money);
        money -= money;
        System.out.println();
    }

    public static void main(String[] args) {
        mainMenu();
    }
}