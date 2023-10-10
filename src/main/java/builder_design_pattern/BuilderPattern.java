package builder_design_pattern;

class Vehicle //Vehicle is the class that you want to construct using the Builder pattern.
{
    private String engine;
    private int wheel;
    private int airbags;
    //It has private fields for engine, wheel, and airbags, as well as getter methods for these fields

    public String getEngine()
    {
        return this.engine;
    }

    public int getWheel()
    {
        return this.wheel;
    }

    public int getAirbags()
    {
        return this.airbags;
    }

    private Vehicle(VehicleBuilder builder) //The Vehicle class has a private constructor that takes a VehicleBuilder as a parameter
    {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
        // This constructor is used to initialize the Vehicle instance based on the values provided by the builder.
    }

    public static class VehicleBuilder //VehicleBuilder is a static inner class of Vehicle, which is responsible for building Vehicle objects
    {
        private String engine;
        private int wheel;
        private int airbags;
        public VehicleBuilder(String engine, int wheel)
        {
            this.engine = engine;
            this.wheel = wheel;
        }
        //It has fields for engine, wheel, and airbags, and a constructor that requires engine and wheel values

        public VehicleBuilder setAirbags(int airbags)
        {
            this.airbags = airbags;
            return this;
        }
        // It also provides a setAirbags method for setting the optional airbags value and a build method that creates a Vehicle instance using the provided values

        public Vehicle build()
        {
            return new Vehicle(this); //just return
        }
    }
}

public class BuilderPattern
{
    public static void main(String[] args)
    {
        Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build(); //We create a car object using the VehicleBuilder and set its engine, wheel, and airbags values using method chaining. Then, we call build to create the Vehicle instance
        Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build(); //And we create a bike object using the VehicleBuilder, setting only the engine and wheel values. Since we didn't set the airbags value, it remains at its default value (0)

        System.out.println(car.getEngine());
        System.out.println(car.getWheel());
        System.out.println(car.getAirbags());

        System.out.println(bike.getEngine());
        System.out.println(bike.getWheel());
        System.out.println(bike.getAirbags());
        //This approach allows we to create instances of Vehicle with different configurations while providing a clean and fluent API for constructing objects. It also ensures that the Vehicle class remains immutable after construction, which is a common requirement for such patterns.
    }
}
