package bridge_design_pattern;


abstract class TV //TV is an abstract class representing different types of TVs
{
    Remote remote; //It has a reference to a Remote object, which represents the remote control for the TV
    TV(Remote r)
    {
        this.remote = r;
    }
    abstract void on();
    abstract void off();
}

class Sony extends TV //Sony is concrete subclasses of TV. He takes a Remote object as a parameter in their constructors, allowing you to associate a specific type of remote with a TV.
{
    Remote remoteType;
    Sony(Remote r)
    {
        super(r);
        this.remoteType = r;
    }

    public void on()
    {
        System.out.print("Sony TV ON: ");
        remoteType.on();
    }

    public void off()
    {
        System.out.print("Sony TV OFF: ");
        remoteType.off();
    }
}

class Philips extends TV //Philips is the same as Sony bcz he takes a Remote object as a parameter in their constructors, allowing you to associate a specific type of remote with a TV.
{
    Remote remoteType;
    Philips(Remote r)
    {
        super(r);
        this.remoteType = r;
    }

    public void on()
    {
        System.out.print("Philips TV ON: ");
        remoteType.on();
    }

    public void off()
    {
        System.out.print("Philips TV OFF: ");
        remoteType.off();
    }
}

interface Remote //Remote is an interface that defines the operations for a remote control, which are on() and off().
{
    public void on();
    public void off();
}

class OldRemote implements Remote //OldRemote is concrete implementations of the Remote interface, representing two different types of remotes with their own on() and off() behaviors.
{
    @Override
    public void on()
    {
        System.out.println("ON with Old Remote");
    }

    @Override
    public void off()
    {
        System.out.println("OFF with old Remote");
    }

}

class NewRemote implements Remote //NewRemote is the same as Oldremote, which means that he has the same act like OldRemote
{
    @Override
    public void on()
    {
        System.out.println("ON with New Remote");
    }

    @Override
    public void off()
    {
        System.out.println("OFF with New Remote");
    }
}

public class BridgePattern
{
    public static void main(String[] args) //In main method, we can see how the Bridge pattern works by creating instances of TVs (Sony and Philips) and associating them with different types of remotes (OldRemote and NewRemote)
    {
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();
        //When I call the on() and off() methods on the TVs, they delegate the operations to the respective remote implementations, allowing you to change the remote's behavior independently of the TV.
    }
}