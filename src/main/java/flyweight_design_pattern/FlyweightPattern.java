package flyweight_design_pattern;

import java.util.HashMap;
import java.util.Random;
interface Employee //Employee is an interface
{
    public void assignSkill(String skill);
    public void task();
    //This interface can define the common methods for assigning skills and performing tasks
}

class Developer implements Employee //Developer is concrete classes that implement the Employee interface
{

    private final String JOB;
    private String skill;

    public Developer()
    {
        JOB = "Fix the issue";
    }

    @Override
    public void assignSkill(String skill)
    {
        this.skill = skill;
    }

    @Override
    public void task()
    {
        System.out.println("Developer with skill: " + this.skill + " with Job: " + JOB);
    }
    //It represents the different types of employees and store its specific job roles ("Fix the issue" for Developers and "Test the issue" for Testers) and skills

}

class Tester implements Employee //Tester is concrete classes that implement the Employee interface
{
    private final String JOB;
    private String skill;
    public Tester()
    {
        JOB = "Test the issue";
    }

    @Override
    public void assignSkill(String skill)
    {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Tester with Skill: " + this.skill + " with Job: " + JOB);
    }
    //It represents the different types of employees and store its specific job roles ("Fix the issue" for Developers and "Test the issue" for Testers) and skills
}


class EmployeeFactory //EmployeeFactory is a factory class responsible for creating and reusing employee objects
{
    private static HashMap<String, Employee> m = new HashMap<String, Employee>(); // It maintains a HashMap to store and reuse created employee objects based on their type (e.g., "Developer" or "Tester")

    public static Employee getEmployee(String type)
    {
        Employee p = null;
        if(m.get(type) != null)
        {
            p = m.get(type);
        }
        else
        {
            switch(type)
            {
                case "Developer":
                    System.out.println("Developer Created");
                    p = new Developer();
                    break;
                case "Tester":
                    System.out.println("Tester Created");
                    p = new Tester();
                    break;
                default:
                    System.out.println("No Such Employee");
            }

            m.put(type, p);
        }
        return p;
        // we use swith and case.for instance if an employee of a specific type is requested and an instance already exists in the HashMap, it returns the existing instance; otherwise, it creates a new instance and stores it in the HashMap for future reuse
    }
}

public class FlyweightPattern
{
    private static String employeeType[] = {"Developer", "Tester"};
    private static String skills[] = {"Java", "C++", ".Net", "Python"};
    public static void main(String[] args) //In the main method, we demonstrate the Flyweight pattern by repeatedly creating employee objects with random types and skills
    {
        for(int i = 0; i < 10; i++)
        {
            Employee e = EmployeeFactory.getEmployee(getRandEmployee());
            e.assignSkill(getRandSkill());
            e.task();
        }
        // If the same type of employee is requested multiple times, the factory reuses the existing instance rather than creating a new one
    }

    public static String getRandEmployee() //getRandEmployee method is used to obtain random employee types for demonstration purposes
    {
        Random r = new Random();
        int randInt = r.nextInt(employeeType.length);
        return employeeType[randInt];
    }

    public static String getRandSkill() //getRandSkill method is used to obtain random skills for demonstration purposes
    {
        Random r = new Random();
        int randInt = r.nextInt(skills.length);
        return skills[randInt];
    }
}