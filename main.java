//Molla Fahad Kolim
//Virtual Pet Simulator
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

//Imports libraries used in code
class PetStatus {
    //Record Class holding virtual pets details
    String PetName;
    String PetSpecies;
    Integer PetHunger;
    Integer PetHappiness;
}

class Main {
    public static void main(String[] args) {
        CompleteProgram();
        System.exit(0);
    }

    public static void CompleteProgram() {
        //Main method initializing arrays and calling other methods necessary
        //to make program work
        Scanner scan = new Scanner(System.in);
        PetStatus Pet1 = new PetStatus();
        //Creates new instance of record called Pet1, which we use to store pet
        //details in and call all over the code
        IntroductionMessage();
        //Prints an introductory message telling user the point of the game.
        String[] names;
        String[] species;
        Integer[] Hunger;
        Integer[] Happiness;
        //Stating arrays that are going to be used later on
        System.out.println("How many pets would you like? ");
        final Integer numberofpets = scan.nextInt();
        //Takes user input and saves as a final Integer, meaning the
        //numberofpets variable cannot be changed after entered
        names = new String[numberofpets];
        species = new String[numberofpets];
        Hunger = new Integer[numberofpets];
        Happiness = new Integer[numberofpets];
        //Initializes the arrays, giving them an array size of variable
        //numberofpets
        for (int i = 0; i < numberofpets; i++) {
            names[i] = PetName(Pet1, i);
            Hunger[i] = PetHunger(Pet1, Hunger);
            Happiness[i] = pethappiness(Pet1, Happiness);
            PetHungerState(Pet1);
            PetHappinessState(Pet1);
            //For loop - for however many pets the user wants, they will be
            //allowed to enter their name, initiate a hunger and happiness level.
        }
        if (numberofpets > 1) {
            //Only execute method AlphabeticalSort is user has >1 pets
            AlphabeticalSort(numberofpets, names);
            //Alphabetically sort the inputted pets names and display back to
            //the user
        }
        PetRounds(Pet1, names, Hunger, Happiness, numberofpets);
        //Method that controls the rounds. Takes inputs
    }

    //ADT PetStatus
    //getPetName, setPetName
    public static String getPetName(PetStatus Pet1) {
        return Pet1.PetName;
    } //Getters get record fields to save elements to

    //ADT, sets record field elements, takes chosenpet as argument and saves
    //into record field PetStatus
    //Overwrites currently held name in field PetName with newly user inputted
    //value and gets called throughout the program.
    public static PetStatus setPetName(PetStatus Pet1, String chosenpet) {
        Pet1.PetName = chosenpet.substring(0, 1).toUpperCase() + chosenpet.substring(1);
        return Pet1;
    } //Returns Pet1 with new element to object PetStatus

    public static String setpetName(PetStatus Pet1, String petname) {
        Pet1.PetName = petname;
        return Pet1.PetName;
    }

    //Introductory message for user to see, explaining program and how to play
    public static void IntroductionMessage() {
        //Introduction method telling user what the program does and how to
        //play.
        System.out.println("Welcome to the Pet Game! This is a game that"
                + " immitates a real life pet that you must look after.");
        System.out.println("The rules are simple, you first name however many"
                + " pets you wish to look after.");
        System.out.println("You will then have to take care of your pet for 10"
                + " rounds, by either inputting the keywords 'feed' or 'play'.");
        System.out.println("This will improve your pets mood, if you survive"
                + " without ignoring your pets needs for more than 2 rounds you win the game!");
        System.out.println("If you ignore your pets needs for more than 2"
                + " rounds, than you lose :( Good Luck!");
        System.out.println("");
    }

    //Takes arrays defined in may as arguments
    public static String PetName(PetStatus Pet1, int i) {
        //Method that allows the user to name their pet and species
        Scanner scan = new Scanner(System.in);
        System.out.println("What would you like to name your " + (i + 1) + " pet? ");
        //Asks user what they would like to name their pet, uses 'i' to display
        //the pet number they are naming.
        String petname = scan.nextLine();
        //Saves user input in variable petname of type string
        petname = setpetName(Pet1, petname).toLowerCase();
        //Also saves petname into record field PetName
        System.out.println("Whats the species of " + petname + " ?");
        //Asks user for their pets species
        Pet1.PetName = petname;
        String petspecies = scan.nextLine().toLowerCase();
        //Saves user input in variable petspecies of type string
        Pet1.PetSpecies = petspecies;
        //Saves the pets species in record field PetSpecies
        System.out.println("Happy 0th birthday to " + petname + " the " + petspecies);
        //Prints a message taking their pets name and species
        System.out.println("");
        return petname;
        //Returns petname
    }

    public static Integer PetHunger(PetStatus Pet1, Integer[] Hunger) {
        //Method that randomly generates a hunger value for pets.
        int Low = 1;
        int High = 5;
        //Setting boundaries of generated number, numbers include 1 2 3 4 5
        Random rand = new Random();
        //Random library initiation
        int hunger = rand.nextInt(High - Low) + Low;
        //Randomly generated number gets saved into variable hunger of type
        //Integer
        Pet1.PetHunger = hunger;
        //Saves newly generated hunger value into record field PetHunger
        return hunger;
        //Returns hunger
    }

    public static Integer pethappiness(PetStatus Pet1, Integer[] Happiness) {
        //Method generates a random happiness value for pet
        int Low = 1;
        int High = 5;
        //Set boundaries dictating the range of the randomly generated value
        Random rand1 = new Random();
        int happiness = rand1.nextInt(High - Low) + Low;
        //Randomly generated value gets saved into variable happiness
        Pet1.PetHappiness = happiness;
        //Saves randomly generated value into record field PetHappiness
        return happiness;
        //Returns happiness
    }

    public static void PetHungerState(PetStatus Pet1) {
        //Rather than outputting a number that doesn't mean much to user, this
        //method takes the randomly generated number and prints out a statement instead
        //If loops that prints different messages according to whatever the
        //randomly generated number is
        if (Pet1.PetHunger == 5) {
            System.out.println("Your pet is really hungry, feed them!");
            System.out.println("");
        }
        if (Pet1.PetHunger == 4) {
            System.out.println("Their hunger level is low, feed them!");
            System.out.println("");
        }
        if (Pet1.PetHunger == 3) {
            System.out.println("Their hunger level is ok, feed them soon!");
            System.out.println("");
        }
        if (Pet1.PetHunger == 2) {
            System.out.println("Your pets' hunger is full");
            System.out.println("");
        }
        if (Pet1.PetHunger == 1) {
            System.out.println("Your pet is bloated, let them rest.");
            System.out.println("");
        }
    }

    public static void PetHappinessState(PetStatus Pet1) {
        //Rather than outputting a number that doesn't mean much to user, this
        //method takes the randomly generated number and prints out a statement instead
        //If loops that prints different messages according to whatever the
        //randomly generated number is
        if (Pet1.PetHappiness == 5) {
            System.out.println("Your pet is really sad, play with them!");
            System.out.println("");
        }
        if (Pet1.PetHappiness == 4) {
            System.out.println("Your pet is bored, play with them!");
            System.out.println("");
        }
        if (Pet1.PetHappiness == 3) {
            System.out.println("Your pet is kinda bored, play with them if you"
                    + " have time!");
            System.out.println("");
        }
        if (Pet1.PetHappiness == 2) {
            System.out.println("Your pet is happy!");
            System.out.println("");
        }
        if (Pet1.PetHappiness == 1) {
            System.out.println("Your pet is really happy!");
            System.out.println("");
        }
    }

    public static void PetRounds(PetStatus Pet1, String[] names, Integer[] Hunger,
            Integer[] Happiness, int numberofpets) {
        //Core method for program to work, loops the rounds and outputs whether
        //they won or lost.
        Integer counter = 2;
        //Stating the counter will always start from 2, users can only make 2
        //mistakes before the program ends and displays 'you lost' message
        for (int i = 1; i < 11; i++) {
            //For loops that runs a total of 10 times, meaning the user has to
            //play the game for 10 rounds in order to win. For every itteration i gets +1,
            //stopping when i < 11
            PetChooser(Pet1, i, names);
            //Calls PetChooser method, allows user to choose which pet to look
            //after
            Scanner scan = new Scanner(System.in);
            System.out.println("Lives left " + counter);
            //Prints the status of counter
            System.out.println("");
            System.out.println("On a level of 1-5, your pets hunger level is"
                    + " currently " + Pet1.PetHunger);
            System.out.println("On a level of 1-5, your pets happiness level is"
                    + " currently " + Pet1.PetHappiness);
            //Prints out the hunger and happiness status of the pet
            System.out.println("");
            if (Pet1.PetHunger.equals(5)) {
                //If the randomly generated number is 5, and because we count
                //pet status on a level from 1 to 5, we output an automated message.
                System.out.println("Round " + i + " would you like to feed or"
                        + " play with " + getPetName(Pet1) + "? ");
                System.out.println("Because " + getPetName(Pet1) + "s' current"
                        + " hunger level is full, you can only play with them this round. ");
                //Prints out that cannot go over 5, so +1 on other value
                Pet1.PetHappiness++;
                //Adds 1 on to the other value and saves into record
                if (counter == 2) {
                    //If counter is 2, do nothing. Because we are only giving
                    //user 2 chances to fail counter cannot go over 2
                    ;
                } else {
                    counter = counter + 1;
                }
                System.out.println(getPetName(Pet1) + "'s happiness level is"
                        + " now " + Pet1.PetHappiness);
                //Print a message stating the current status of the pets hunger
                //and happiness level
                System.out.println("");
                i++;
                //Adds 1 on to the counter to say 1 round has been completed
                System.out.println("");
                int Low = 1;
                int High = 4;
                Random rand1 = new Random();
                int happiness = rand1.nextInt(High - Low) + Low;
                //Makes new range for randomly generated values, done as a
                //precaution in case the randomly generated value is 5. If so cannot enter the
                //loop again and will allow level to go over 5
                //Generates random number between 1-5
                Pet1.PetHappiness = happiness;
                //Saves happiness into record field PetHappiness
                System.out.println("Lives left " + counter);
                //Prints out the number of lives the user has left
                PetHunger(Pet1, Hunger);
                pethappiness(Pet1, Happiness);
                //Calls methods to randomly generated values with new limits
                System.out.println("On a level of 1-5, your pets hunger level"
                        + " is currently " + Pet1.PetHunger);
                System.out.println("On a level of 1-5, your pets happiness"
                        + " level is currently " + Pet1.PetHappiness);
                //Prints out the newly generated values as pets new status
                //levels.
            }
            if (Pet1.PetHappiness.equals(5)) {
                //This one is similar to the if loop above, but this is for
                //Happiness level instead of hunger
                System.out.println("Round " + i + " would you like to feed or"
                        + " play with " + getPetName(Pet1) + "? ");
                System.out.println(getPetName(Pet1) + "s' current happiness"
                        + " level is full, you can only feed them this round. ");
                Pet1.PetHunger++;
                System.out.println(getPetName(Pet1) + "s' hunger level is now "
                        + Pet1.PetHunger);
                if (counter == 2) {
                    ;
                } else {
                    counter = counter + 1;
                }
                System.out.println(counter);
                System.out.println("");
                i++;
                //Same concept as explained above
                System.out.println("");
                int Low = 1;
                int High = 4;
                Random rand1 = new Random();
                int happiness = rand1.nextInt(High - Low) + Low;
                //Generates random number between 1-5
                Pet1.PetHappiness = happiness;
                //Saves happiness into record pet1
                System.out.println("Lives left " + counter);
                PetHunger(Pet1, Hunger);
                pethappiness(Pet1, Happiness);
                System.out.println("On a level of 1-5, your pets hunger level"
                        + " is currently " + Pet1.PetHunger);
                System.out.println("On a level of 1-5, your pets happiness"
                        + " level is currently " + Pet1.PetHappiness);
            }
            System.out.println("Round " + i + " would you like to feed or play"
                    + " with " + getPetName(Pet1) + "? ");
            //If randomly generated value is not 5, then output round number
            //and use ADT to getPetName
            String Action = scan.nextLine().toLowerCase();
            //Awaits for user input - can either be feed or play and saves into
            //variable Action of type String
            if (Action.equals("play")) {
                //If user input is 'play', jump into this if loop
                if (Pet1.PetHunger == 1 & (Action != "feed")) {
                    counter = counter - 1;
                } //If user input is 'play' whilst PetHunger value is 1 (lowest
                //possible level) then -1 from counter
                if (Pet1.PetHappiness == 1 & (Action.equals("play"))) {
                    if (counter == 2) {
                        ; //If counter is 2, do nothing. As we dont want
                        //counter to >2
                    } else {
                        counter = counter + 1;
                    } //Else if user input is 'play' whilst PetHappiness is 1,
                    //then +1 to counter
                }
                if (Pet1.PetHunger == 1 & Pet1.PetHappiness == 1) {
                    counter = counter - 1;
                } //If both randomly generated values are 1, then -1 from
                //counter regardless of user input
                Pet1.PetHappiness++;
                //Adds +1 to value held in PetHappiness
                System.out.println(getPetName(Pet1) + " happiness level is now"
                        + " at " + Pet1.PetHappiness);
                //Prints out current state of pet using ADT getPetName
                PetHunger(Pet1, Hunger);
                pethappiness(Pet1, Happiness);
                //Randomly generates new values of Hunger and Happiness
                System.out.println("");
            }
            if (Action.equals("feed")) {
                //Same concept as explained above, but this if loop is inversed.
                //Top was for happiness whilst this is for hunger
                if (Pet1.PetHappiness == 1 & (Action != "play")) {
                    counter = counter - 1;
                }
                if (Pet1.PetHunger == 1 & (Action.equals("feed"))) {
                    if (counter == 2) {
                        ;
                    } else {
                        counter = counter + 1;
                    }
                }
                if (Pet1.PetHunger == 1 & Pet1.PetHappiness == 1) {
                    counter = counter - 1;
                }
                Pet1.PetHunger++;
                System.out.println(getPetName(Pet1) + " hunger level is now at"
                        + " " + Pet1.PetHunger);
                PetHunger(Pet1, Hunger);
                pethappiness(Pet1, Happiness);
                System.out.println("");
            }
            if (counter == 0) {
                System.out.print("You lost, you didnt take care of your pet"
                        + " properly!");
                System.exit(0);
            }
            if (!Action.equals("feed") && !Action.equals("play")) {
                System.out.println("Action not recognised, try again.");
                i--;
            }
        }
        ProgramComplete();
        //If user gets past 10 rounds regardless of lives left in counter,
        //prints out a congratulation message and exits program.
    }

    public static void PetChooser(PetStatus Pet1, int numberofpets, String[] names) {
        System.out.println("Heres a list of all your pets: ");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i].substring(0, 1).toUpperCase()
                    + names[i].substring(1));
        }
        //Method that allows user to choose which pet they wish to look after
        //if theres multiple
        Scanner scan = new Scanner(System.in);
        System.out.println("Which pet would you like to interact with? ");
        //Asks which pet the user wishes to look after
        String chosenpet = scan.nextLine().toLowerCase();
        //Takes user input thats saved into variable chosenpet, and passes to
        //method setPetName. Sets new name for field PetName
        String tovalidate = chosenpet;
        //Transfers chosenpet to tovaliadete
        if (Arrays.toString(names).contains(tovalidate)) {
            Pet1 = setPetName(Pet1, chosenpet);
        } else {
            System.out.println("Pet doesnt exist");
            PetChooser(Pet1, numberofpets, names);
        }
        //If loops to make sure user input pet exists else ask them to input it
        //again
    }

    public static void AlphabeticalSort(int numberofpets, String[] names) {
        //Bubble sort sorting method
        String temporary;
        //Makes new temporary string to save values in when sorting
        for (int i = 0; i < numberofpets; i++) {
            for (int y = i + 1; y < numberofpets; y++) {
                if (names[i].compareTo(names[y]) > 0) {
                    //Compares names of index i, to the value next to it - names
                    //of index y
                    temporary = names[i];
                    names[i] = names[y];
                    names[y] = temporary;
                    //If its greater, swap names[i] into temporary variable.
                    //Swap values over and lastly save the value in temporary in names[y]
                }
            }
        }
        System.out.println("Heres a list of all your pets in alphabetical order:");
        for (int i = 0; i <= numberofpets - 1; i++) {
            System.out.println(names[i].substring(0, 1).toUpperCase()
                    + names[i].substring(1));
        }//Capitalize first letter when printed
        //Prints out the sorted list for user to see.
    }

    public static void ProgramComplete() {
        System.out.println("Congratulation you won! You succesfully took care"
                + " of your pets for 10 rounds.");
        //Prints out a congratulatory message if user passes 10 rounds.
    }
}
