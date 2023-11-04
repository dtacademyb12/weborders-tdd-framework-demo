package misc.lombokdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog {

    private int age;
    private String color;


    public static void main(String[] args) {
         Dog dog = new Dog();
         dog.getAge();
         dog.setAge(34);
         dog.toString();
         dog.equals(34);
         dog.hashCode();
    }
}
