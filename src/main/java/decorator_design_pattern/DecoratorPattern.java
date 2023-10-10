package decorator_design_pattern;

interface Dress //Dress is an interface
{
    public void assemble(); //And declares a method assemble(), which represents the basic behavior of a dress
}

class BasicDress implements Dress //BasicDress is a concrete class that implements the Dress interface
{
    @Override
    public void assemble() //. It represents the basic dress with its default features and behavior
    {
        System.out.println("Basic Dress Features");
    }
}

class DressDecorator implements Dress //DressDecorator is an abstract class that implements the Dress interface
{
    protected Dress dress; //t has a reference to a Dress object (dress)
    public DressDecorator(Dress c)
    {
        this.dress = c;
    }

    @Override
    public void assemble() // and delegates the assemble() method to this object. This is the base class for all decorators
    {
        this.dress.assemble();
    }
}

class CasualDress extends DressDecorator //CasualDress is concrete decorator classes that extend DressDecorator
{
    public CasualDress(Dress c)
    {
        super(c);
    }

    @Override
    public void assemble()
    {
        super.assemble();
        System.out.println("Adding Casual Dress Features");
    }
    //this class add specific features to the dress by overriding the assemble() method to include their own features and calling the assemble() method of the wrapped Dress object
}


class SportyDress extends DressDecorator //SportyDress is concrete decorator classes that extend DressDecorator
{
    public SportyDress(Dress c)
    {
        super(c);
    }

    @Override
    public void assemble()
    {
        super.assemble();
        System.out.println("Adding Sporty Dress Features");
    }
    //this class add specific features to the dress by overriding the assemble() method to include their own features and calling the assemble() method of the wrapped Dress object
}

class FancyDress extends DressDecorator //FancyDress is concrete decorator classes that extend DressDecorator
{
    public FancyDress(Dress c)
    {
        super(c);
    }

    @Override
    public void assemble()
    {
        super.assemble();
        System.out.println("Adding Fancy Dress Features");
    }
    //this class add specific features to the dress by overriding the assemble() method to include their own features and calling the assemble() method of the wrapped Dress object
}

public class DecoratorPattern //we create instances of various dress combinations, starting with a BasicDress
{
    public static void main(String[] args) //and then we wrap them with different decorators (SportyDress, FancyDress, CasualDress) to add additional features

    {
        Dress sportyDress = new SportyDress(new BasicDress());
        sportyDress.assemble();
        System.out.println();

        Dress fancyDress = new FancyDress(new BasicDress());
        fancyDress.assemble();
        System.out.println();

        Dress casualDress = new CasualDress(new BasicDress());
        casualDress.assemble();
        System.out.println();

        Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
        sportyFancyDress.assemble();
        System.out.println();

        Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
        casualFancyDress.assemble();
        //we call the assemble() method on each dress object to demonstrate how the decorators add features to the basic dress
    }
}