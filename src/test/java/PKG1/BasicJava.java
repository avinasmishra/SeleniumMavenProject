package PKG1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicJava {
    public static void main(String[] args) {

        //Array Concept
        int[] arr = new int[3];
        arr[0]=1;
        arr[1]=2;
        arr[2]=3;

        //2nd way
        String[] name = {"Rahul","Ram","Avi"};

        //for loop for iteration of elements/value
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }

        //for-Each loop
        for(String s: name)
        {
            System.out.println(s);
        }
        System.out.println("///////////////");

        //ArrayList- Here size of arrayList is dynamically increasing but not in Array
        List<String> name1 = new ArrayList<String>();
        name1.add("Kunal");
        name1.add("Reads");
        name1.add("Book");
        //iteration- we use get(index) method
        System.out.println(name1.get(2));
        System.out.println("/////////////////");
        //for loop
        for(int i=0;i<name1.size();i++)
        {
            System.out.println(name1.get(i));
        }
        //products present or not -Use contains() method- return type true/false. Case sensentive
        System.out.println(name1.contains("Reads"));
        System.out.println("/////////////////");
        //How to convert Array to ArrayList
        String[] parentName = {"Rahul1","Ram1","Avi1"};
        List<String> nameArayList = Arrays.asList(parentName);
        for(String name2:nameArayList)
        {
            System.out.println(name2);
        }

        ///String - String is an object
        //2 ways to declare String 1. String literal(won't create another memory allocation for same string value, if its different value will create space for that
        String s1 = "Avinash Kumar Mishra";
        String s2 = "Avinash Kumar Mishra";

        //2. String with new key- will create memory for each creation
        String s3 = new String("welcome");
        String s4 = new String("welcome");

        //splitting the string
        String s5 = "Avinash Kumar Mishra";
        //use split() method,after split we use array to store the value
        String[] splittedString = s5.split(" ");
        for (String sp: splittedString)
        {
            System.out.println(sp);
        }
        System.out.println("////////////");
        String[] splittedString1 = s5.split("Kumar");
        for (String sp1: splittedString1)
        {
            System.out.println(sp1);
        }
        //trim() method- used to remove right left space
        System.out.println(splittedString1[1].trim());

    }
}
