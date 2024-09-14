import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void greet() {
        System.out.println("Hello, my name is " + name);
    }
}

interface QueueBehavior {
    void enqueue(Person person);
    Person dequeue();
}

interface MarketBehavior {
    void addPerson(Person person);
    void removePerson();
    void update();
}

class Market implements QueueBehavior, MarketBehavior {
    private List<Person> people = new ArrayList<>();

    @Override
    public void enqueue(Person person) {
        people.add(person);
        System.out.println(person.getName() + " joined the queue.");
    }

    @Override
    public Person dequeue() {
        if (!people.isEmpty()) {
            return people.remove(people.size() - 1);
        } else {
            return null;
        }
    }

    @Override
    public void addPerson(Person person) {
        people.add(person);
        System.out.println("Added " + person.getName() + " to the store.");
    }

    @Override
    public void removePerson() {
        if (!people.isEmpty()) {
            people.remove(people.size() - 1);
        }
    }

    @Override
    public void update() {
        for (Person person : people) {
            person.greet();
        }
    }
}


Person person1 = new Person("John");
Market market = new Market();
market.enqueue(person1);
market.update(); 
Person removedPerson = market.dequeue();
removedPerson.greet(); 

