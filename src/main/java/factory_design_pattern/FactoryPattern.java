package factory_design_pattern;
abstract class Vehicle //Vehicle is an abstract class that defines the common interface for all vehicles
{
    public abstract int getWheel(); // It has an abstract method getWheel()
    public String toString() // retrieve the number of wheels for a vehicle and a toString() method that returns a string representation of the vehicle's wheel count
    {
        return "Wheel: " + this.getWheel();
    }
}

class Car extends Vehicle //Car is concrete classes that extend the Vehicle class
{
    int wheel;
    Car(int wheel)
    {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() //It implements the getWheel() method to provide the specific wheel count for cars
    {
        return this.wheel;
    }
}

class Bike extends Vehicle // Bike is concrete classes that extend the Vehicle class
{
    int wheel;
    Bike(int wheel)
    {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() //It implements the getWheel() method to provide the specific wheel count for.
    {
        return this.wheel;
    }
}

class VehicleFactory //VehicleFactory is a factory class
{
    public static Vehicle getInstance(String type, int wheel) //This class that provides a static method getInstance(String type, int wheel) for creating instances of vehicles. It takes two parameters: the type of vehicle ("car" or "bike") and the number of wheels for the vehicle
    {
        if(type == "car")
        {
            return new Car(wheel);
        }
        else if(type == "bike")
        {
            return new Bike(wheel);
        }
        return null;
    }
    //Based on the type, it creates and returns the corresponding vehicle instance
}

public class FactoryPattern
{
    public static void main(String[] args) //in the main method, we demonstrate how to use the VehicleFactory to create instances of cars and bikes
    {
        Vehicle car = VehicleFactory.getInstance("car", 4);
        System.out.println(car);

        Vehicle bike = VehicleFactory.getInstance("bike", 2);
        System.out.println(bike);
        //we specify the type and the number of wheels as parameters to getInstance, and it returns the appropriate vehicle instance
    }
}
