# HamburgerHelper_V2
A new and improved hamburger helper
Food is the parent class. 
Hamburger is a different parent class.

Each package has two classes. One is what controls the list of the kind of food, and one is the parent of the kind of food.
    -Topping
    -Condiment
    -MeatType
    -BreadType
    -CheeseType
    
    -HamburgerType
    
 The list classes call a certain file to get the inventory data for the restaurant. 
 They are in the resource folder.
 For the 5 ingredient classes, the format for the text file is
   "Type",count,price
   
 For the HamburgerType class the format is
  Name,MeatType,CheeseType,RollType,list:of:toppings,list:of:condiments,price,description
  
 The program parses each file on commas, so for the lists, we parse again using the list. 
 If there are no toppings write null. If there are no condiments, write null.
