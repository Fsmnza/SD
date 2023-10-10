package prototype_design_pattern;

import java.util.ArrayList;
import java.util.List;

class Vehicle implements Cloneable //Vehicle is a class that implements the Cloneable interface
{
    private List<String> vehicleList; //It has a vehicleList field, which is a list of vehicle names

    public Vehicle() {
        this.vehicleList = new ArrayList<String>();// first constructor initializes an empty vehicleList
    }
    public Vehicle(List<String> list)
    {
        this.vehicleList = list; //and the other takes a list as a parameter and sets the vehicleList to that list
    }

    public void insertData() //The insertData method populates the vehicleList with some sample vehicle names
    {
        vehicleList.add("Honda amaze");
        vehicleList.add("Audi A4");
        vehicleList.add("Hyundai Creta");
        vehicleList.add("Maruti Baleno");
        vehicleList.add("Renault Duster");
    }

    public List<String> getVehicleList() //the getVehicleList method allows you to retrieve the list of vehicle names
    {
        return this.vehicleList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException //the clone method, which is part of the Cloneable interface
    {
        List<String> tempList = new ArrayList<String>();//overrides the default cloning behavior

        for(String s : this.getVehicleList())
        {
            tempList.add(s);//It creates a deep copy of the Vehicle object by copying the elements of the vehicleList into a new list
        }

        return new Vehicle(tempList); //and returning a new Vehicle instance with this list
    }
}

public class PrototypePattern
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
        Vehicle a = new Vehicle();
        a.insertData(); //in the main method, you create an initial Vehicle instance a

        Vehicle b = (Vehicle) a.clone(); // insert some data into it, and then clone it into a new instance b
        List<String> list = b.getVehicleList(); //we modify the b instance by adding a new vehicle name to its list
        list.add("Honda new Amaze");

        System.out.println(a.getVehicleList());
        System.out.println(list);

        b.getVehicleList().remove("Audi A4");
        System.out.println(list);
        System.out.println(a.getVehicleList());
        //we print the contents of both a and b to demonstrate that they have separate lists
    }

}