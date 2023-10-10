package observer_design_pattern;

import java.util.ArrayList;
import java.util.List;

interface Subject //Subject is an interface
{
    void register(Observer obj);
    void unregister(Observer obj);
    void notifyObservers();
    //this interface that defines the methods for registering observers, unregistering observers, and notifying observers of change
}

class DeliveryData implements Subject //DeliveryData is a concrete class that implements the Subject interface
{
    private List<Observer> observers; //It maintains a list of registered observers (observers) and a location field. It allows observers to register, unregister, and receive notifications when the location changes
    private String location;

    public DeliveryData()
    {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj)
    {
        observers.add(obj);
    }

    @Override
    public void unregister(Observer obj)
    {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers()
    {
        for(Observer obj : observers)
        {
            obj.update(location);
        }
    }

    public void locationChanged() //The locationChanged method simulates a change in the location and notifies registered observers
    {
        this.location = getLocation();
        notifyObservers();
    }

    public String getLocation()
    {
        return "YPlace";
    }
}


interface Observer //Observer is an interface
{
    public void update(String location); //this  interface that defines the update method, which is called when the subject notifies observers of changes
}


class Seller implements Observer //Seller is concrete classes that implement the Observer interface
{
    private String location;

    @Override
    public void update(String location)
    {
        this.location = location;
        showLocation();
    }

    public void showLocation()
    {
        System.out.println("Notification at Seller - Current Location: " + location);
    }
    // that observer class define its update method to react to location changes and display a notification message
}

class User implements Observer //User is concrete classes that implement the Observer interface
{
    private String location;

    @Override
    public void update(String location)
    {
        this.location = location;
        showLocation();
    }

    public void showLocation()
    {
        System.out.println("Notification at User - Current Location: " + location);
    }
    // that observer class define its update method to react to location changes and display a notification message
}

class DeliveryWarehouseCenter implements Observer //DeliveryWarehouseCenter is concrete classes that implement the Observer interface
{
    private String location;

    @Override
    public void update(String location)
    {
        this.location = location;
        showLocation();
    }

    public void showLocation()
    {
        System.out.println("Notification at Warehouse - Current Location: " + location);
    }
    // that observer class define its update method to react to location changes and display a notification message
}

public class ObserverPattern
{
    public static void main(String[] args) //in the main method, we demonstrate the Observer pattern by creating a DeliveryData subject
    {
        DeliveryData topic = new DeliveryData();

        Observer obj1 = new Seller();
        Observer obj2 = new User();
        Observer obj3 = new DeliveryWarehouseCenter();

        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);
        //registering three different observers, changing the location, and then unregistering one observer

        topic.locationChanged();
        topic.unregister(obj3);
        //The location change triggers notifications to all registered observers
        System.out.println();
        topic.locationChanged();
    }
}
