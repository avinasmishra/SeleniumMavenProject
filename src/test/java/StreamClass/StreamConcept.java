package StreamClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamConcept {

    @Test
    public void regularMethod()
    {
        System.out.println("###Using Regular function###");
        //count number of name starting with alphabets A in list
        List<String> names = new ArrayList<String>();
        names.add("Avinash");
        names.add("Balram");
        names.add("Akash");
        names.add("DG");
        names.add("Kunal");
        names.add("ayush");
        int count =0;

        for(int i=0;i< names.size();i++)
        {
            String name = names.get(i);
            if(name.startsWith("A") || name.startsWith("a"))
            {
                count++;
            }
        }
        System.out.println("Regular Count: "+count);
    }

    //using steam() function
    //step1: convert list into stream()
    //step2: use stream() method to filter based on condition
    //step3: after filter use terminal operation
    @Test
    public void streamMethod()
    {
        System.out.println("###Using Stream Function###");
        List<String> names = new ArrayList<String>();
        names.add("Avinash");
        names.add("Balram");
        names.add("Akash");
        names.add("DG");
        names.add("Kunal");
        names.add("ayush");

        //stream with lambda expression count
        long c = names.stream().filter(s-> s.startsWith("A") || s.startsWith("a")).count();
        System.out.println("Count: "+c);

        //print all names
        names.stream().forEach(p-> System.out.println(p));
    }

    @Test
    public void streamWithoutListMethod()
    {
        System.out.println("####Using Stream Function without creating list####");
        //no need to create list/collection- we can create directly using Stream.of() method
        Stream<String> stm = Stream.of("Avinash","Balram","Akash","DG","Kunal","ayush");

        //stream with lambda expression count
        long c = stm.filter(s-> s.startsWith("A") || s.startsWith("a")).count();
        System.out.println("Count: "+c);

        //print all names
        //stm.forEach(p-> System.out.println(p));
        Stream.of("Avinash","Balram","Akash","DG","Kunal","ayush").forEach(s-> {
            System.out.println(s);
        });
    }
    @Test
    public void streamMap()
    {
        System.out.println("#### Stream map ####");
        //convert array to list- then print names in upper letter starting with letter "A" in sorted order
       List<String> name = Arrays.asList("Avinash","Balram","Akash","Kunal","Ayush");
       name.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(p->System.out.println(p));

       //print all names in lower case
        name.stream().sorted().map(s -> s.toLowerCase()).forEach(p->System.out.println(p));

        //assertion- verify "Avinash" present or not- use anyMatch() method
        boolean fg = name.stream().anyMatch(s -> s.contains("Avinash"));
        System.out.println(fg);
        Assert.assertTrue(fg);

    }

    @Test
    public void streamCollect()
    {
        System.out.println("#### Stream map ####");
        //convert array to list- then print names in upper letter starting with letter "A" - store in another list and get the index 2 value
        List<String> name = Arrays.asList("Avinash","Balram","Akash","Kunal","Ayush");

        List<String> li = name.stream().filter(s -> s.startsWith("A")).map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(li.get(2));
        //li.forEach(s->System.out.println(s));

        // unique value - sort value and get 3rd index value
        List<Integer> value = Arrays.asList(1,2,2,1,5,4,3);

       List<Integer> val = value.stream().distinct().sorted().collect(Collectors.toList());
       System.out.println(val.get(3));




    }

}
